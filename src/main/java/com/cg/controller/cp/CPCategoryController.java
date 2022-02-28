package com.cg.controller.cp;


import com.cg.model.Category;
import com.cg.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cp/category")
public class CPCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category/list");
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category/edit");
        Optional<Category> category = categoryService.findById(id);
        modelAndView.addObject("category", category.get());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute Category category) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category/create");
        categoryService.save(category);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView doUpdate(@ModelAttribute Category category, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category/edit");
        category.setId(id);
        categoryService.save(category);
        return modelAndView;
    }
}
