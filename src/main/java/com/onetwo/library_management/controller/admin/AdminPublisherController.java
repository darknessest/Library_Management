package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.Publisher;
import com.onetwo.library_management.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPublisherController {
    private final PublisherService publisherService;


    public AdminPublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/admin/addPublisher")
    public String showCreateForm(Publisher publisher) {
        return "add-publisher";
    }

    @RequestMapping("/admin/add-publisher")
    public String createPublisher(Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-publisher";
        }

        publisherService.createPublisher(publisher);
        model.addAttribute("publisher", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/admin/updatePublisher/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Publisher publisher = publisherService.findPublisherById(id);

        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @RequestMapping("/admin/update-publisher/{id}")
    public String updatePublisher(@PathVariable("id") Long id, Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            publisher.setId(id);
            return "update-publisher";
        }

        publisherService.updatePublisher(publisher);
        model.addAttribute("publisher", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @RequestMapping("/admin/remove-publisher/{id}")
    public String deletePublisher(@PathVariable("id") Long id, Model model) {
        publisherService.deletePublisher(id);

        model.addAttribute("publisher", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

}
