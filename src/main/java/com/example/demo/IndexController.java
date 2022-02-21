package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    List<Book> books;

    @RequestMapping("/")
    public String index() {
        return "redirect:/books-list";
    }

    @RequestMapping(value = "/books-list", method = RequestMethod.GET)
    public String bookList(Model model) {
        if (books == null) books = new ArrayList<>();
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", books);
        return "index";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("book") Book book) {
        books.add(book);
        return "redirect:/books-list";
    }

}
