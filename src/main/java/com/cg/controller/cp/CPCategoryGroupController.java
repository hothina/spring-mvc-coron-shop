package com.cg.controller.cp;


import com.cg.model.Category;
import com.cg.model.CategoryGroup;
import com.cg.service.CategoryGroupService;
import com.cg.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cp/category-group")
public class CPCategoryGroupController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    @GetMapping("")
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category-group/list");
        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
        modelAndView.addObject("categoryGroups", categoryGroups);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category-group/create");

        modelAndView.addObject("categoryGroups", new CategoryGroup());

        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute CategoryGroup categoryGroup) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/category-group/create");

        categoryGroupService.save(categoryGroup);

        modelAndView.addObject("categoryGroups", new CategoryGroup());
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }
}
