package com.example.ksiazki.controllers;

import com.example.ksiazki.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publisher")
    public String getBooks(Model model) {

        model.addAttribute("publisher", publisherRepository.findAll());

        return "publisher";
    }
}
