package com.cg.controller;


import com.cg.model.Category;
import com.cg.model.CategoryGroup;
import com.cg.model.Product;
import com.cg.service.CategoryGroupService;
import com.cg.service.CategoryService;
import com.cg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    @Autowired
    private ProductService productService;

    @RequestMapping
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/index");
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
        modelAndView.addObject("categoryGroups", categoryGroups);
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping("/cate-group/{id}")
    public ModelAndView showCateGroupPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/cate-group");
        return modelAndView;
    }

    @RequestMapping("/single-product")
    public ModelAndView showSingleProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/single-product");
        return modelAndView;
    }
}
