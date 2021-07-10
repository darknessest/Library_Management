package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.Author;
import com.onetwo.library_management.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminAuthorController {
    private final AuthorService authorService;

    public AdminAuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/admin/addAuthor")
    public String showCreateForm(Author author) {
        return "add-author";
    }

    @RequestMapping("/admin/add-author")
    public String createAuthor(Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-author";
        }

        authorService.createAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/admin/updateAuthor/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Author author = authorService.findAuthorById(id);

        model.addAttribute("author", author);
        return "update-author";
    }

    @RequestMapping("/admin/update-author/{id}")
    public String updateAuthor(@PathVariable("id") Long id, Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            author.setId(id);
            return "update-author";
        }

        authorService.updateAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @RequestMapping("/admin/remove-author/{id}")
    public String deleteAuthor(@PathVariable("id") Long id, Model model) {
        authorService.deleteAuthor(id);

        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }

}
