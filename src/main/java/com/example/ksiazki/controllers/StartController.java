package com.example.ksiazki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StartController {
    @RequestMapping("/start")
    public String display()
    {
        return "start";
    }
}