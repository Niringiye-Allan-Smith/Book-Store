package com.example.BookStore.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BookStore.Models.Publisher;
import com.example.BookStore.Services.PublisherService;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.findAllPublishers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.findPublisherById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        return publisherService.findPublisherById(id)
            .map(existingPublisher -> {
                publisher.setId(id);
                return ResponseEntity.ok(publisherService.savePublisher(publisher));
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        return publisherService.findPublisherById(id)
            .map(publisher -> {
                publisherService.deletePublisher(id);
                return ResponseEntity.ok().<Void>build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}