package com.example.ksiazki.controllers;

import com.example.ksiazki.model.Book;
import com.example.ksiazki.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddBook {

    private BookRepository bookRepository;


    public AddBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    @RequestMapping("addbook")
    public String showNewProductPage(Model model) {
        Book book = new Book();
        model.addAttribute("addbook", book);

        return "addbook";
    }
    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String savebook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);


        return "redirect:/books";}}