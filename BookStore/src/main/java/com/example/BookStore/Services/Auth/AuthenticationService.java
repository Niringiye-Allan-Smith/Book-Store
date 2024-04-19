package com.example.BookStore.Services.Auth;
import java.util.ArrayList;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.BookStore.Controllers.Auth.GetAllUsersPayload;
import com.example.BookStore.DTOs.Auth.Payloads.ApiResponse;
import com.example.BookStore.DTOs.Auth.Payloads.JwtAuthenticationResponse;
import com.example.BookStore.DTOs.Auth.Requests.LoginRequest;
import com.example.BookStore.DTOs.Auth.Requests.SignUpRequest;
import com.example.BookStore.Exceptions.AppException;
import com.example.BookStore.Models.Auth.Role;
import com.example.BookStore.Models.Auth.RoleName;
import com.example.BookStore.Models.Auth.User;
import com.example.BookStore.Repository.Auth.PersonRepository;
import com.example.BookStore.Repository.Auth.RoleRepository;
import com.example.BookStore.Repository.Auth.UserRepository;
import com.example.BookStore.Utils.JwtTokenProvider;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
public class AuthenticationService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	public List<GetAllUsersPayload> getAllusers() {
		
		List<GetAllUsersPayload> users = new ArrayList<>();
		
		for (User user : userRepository.findAll()){
			
			GetAllUsersPayload getuser = new GetAllUsersPayload();
			getuser.setEmail(user.getEmail());
			getuser.setUsername(user.getUsername());
		
			users.add(getuser);
		}
		return users;
	}

@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

	/*
	 * Authenticate User
	 */
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

	}

	
	public ResponseEntity<?> getUserById(Long id) {
	    Optional<User> optionalUser = userRepository.findById(id);
	    if (!optionalUser.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "User not found with id: " + id), HttpStatus.NOT_FOUND);
	    }
	    User user = optionalUser.get();
	    
	    return new ResponseEntity<>(new ApiResponse(false, "User results present"), HttpStatus.OK);

	}
	public ResponseEntity<?> getUserByUsername(String username) {
	    Optional<User> optionalUser = userRepository.findByUsername(username);
	    if (!optionalUser.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "User not found with username: " + username), HttpStatus.NOT_FOUND);
	    }
	    User user = optionalUser.get();
	    
	    return new ResponseEntity<>(new ApiResponse(false, "User results present"), HttpStatus.OK);
	}

	
}