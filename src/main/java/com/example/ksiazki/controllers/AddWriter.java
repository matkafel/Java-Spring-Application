package com.example.ksiazki.controllers;

import com.example.ksiazki.model.Writer;
import com.example.ksiazki.repositories.WriterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddWriter {

    private WriterRepository writerRepository;


    public AddWriter(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }



    @RequestMapping("addwriter")
    public String showNewProductPage(Model model) {
        Writer writer = new Writer();
        model.addAttribute("addwriter", writer);

        return "AddWriter";
    }
    @RequestMapping(value = "/save4", method = RequestMethod.POST)
    public String savepublisher(@ModelAttribute("writer") Writer writer) {
        writerRepository.save(writer);


        return "redirect:/writers";}}
