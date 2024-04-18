package com.example.BookStore.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Models.Publisher;
import com.example.BookStore.Repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}