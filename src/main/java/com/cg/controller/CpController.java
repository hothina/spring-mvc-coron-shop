package com.cg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cp")
public class CpController {

    @GetMapping
    public ModelAndView showAdminPage() {
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName("cp/home/index");
        return ModelAndView;
    }

    @GetMapping("/temp")
    public ModelAndView showTempPage() {
        ModelAndView ModelAndView = new ModelAndView();
        ModelAndView.setViewName("cp/home/temp");
        return ModelAndView;
    }
}
