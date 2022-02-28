package com.cg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping
    public ModelAndView showHomePage() {
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName("home/index");
        return ModelAndView;
    }

    @RequestMapping("/single-product")
    public ModelAndView showSingleProductPage() {
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName("home/single-product");
        return ModelAndView;
    }
}
