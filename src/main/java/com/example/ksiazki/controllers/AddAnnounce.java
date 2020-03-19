package com.example.ksiazki.controllers;


import com.example.ksiazki.model.Announce;
import com.example.ksiazki.repositories.AnnounceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddAnnounce {

    private AnnounceRepository announceRepository;


    public AddAnnounce(AnnounceRepository announceRepository) {
        this.announceRepository = announceRepository;
    }



    @RequestMapping("addannounce")
    public String showNewProductPage(Model model) {
        Announce announce = new Announce();
        model.addAttribute("addannounce", announce);

        return "addannounce";
    }
    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String saveannounce(@ModelAttribute("announce") Announce announce) {
        announceRepository.save(announce);


        return "redirect:/announce";}}