package com.example.ksiazki.controllers;

import com.example.ksiazki.repositories.WriterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriterController {

    private WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @RequestMapping("/writers")
    public String getWriters(Model model) {

        model.addAttribute("writers", writerRepository.findAll());

        return "writers";
    }
}
