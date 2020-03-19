package com.example.ksiazki.controllers;

import com.example.ksiazki.model.Publisher;
import com.example.ksiazki.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPublisher {

    private PublisherRepository publisherRepository;


    public AddPublisher(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }



    @RequestMapping("addpublisher")
    public String showNewProductPage(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("addpublisher", publisher);

        return "AddPublisher";
    }
    @RequestMapping(value = "/save3", method = RequestMethod.POST)
    public String savepublisher(@ModelAttribute("publisher") Publisher publisher) {
        publisherRepository.save(publisher);


        return "redirect:/publisher";}}