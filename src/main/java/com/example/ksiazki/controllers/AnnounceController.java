package com.example.ksiazki.controllers;

import com.example.ksiazki.repositories.AnnounceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnounceController {

    private AnnounceRepository announceRepository;

    public AnnounceController(AnnounceRepository announceRepository) {
        this.announceRepository = announceRepository;
    }

    @RequestMapping("/announce")
    public String getBooks(Model model) {

        model.addAttribute("announce", announceRepository.findAll());

        return "announce";
    }
}
