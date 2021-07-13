package com.onetwo.library_management.controller.admin;

import com.onetwo.library_management.entity.Category;
import com.onetwo.library_management.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCategoryController {
    private final CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/addCategory")
    public String showCreateForm(Category category) {
        return "add-category";
    }

    @RequestMapping("/admin/add-category")
    public String createCategory(Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }

        categoryService.createCategory(category);
        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categorys";
    }

    @GetMapping("/admin/updateCategory/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        final Category category = categoryService.findCategoryById(id);

        model.addAttribute("category", category);
        return "update-category";
    }

    @RequestMapping("/admin/update-category/{id}")
    public String updateCategory(@PathVariable("id") Long id, Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-category";
        }

        categoryService.updateCategory(category);
        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categorys";
    }

    @RequestMapping("/admin/remove-category/{id}")
    public String deleteCategory(@PathVariable("id") Long id, Model model) {
        categoryService.deleteCategory(id);

        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categorys";
    }

}
