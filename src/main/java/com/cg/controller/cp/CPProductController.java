package com.cg.controller.cp;


import com.cg.model.Category;
import com.cg.model.CategoryGroup;
import com.cg.model.Product;
import com.cg.model.ProductForm;
import com.cg.service.CategoryGroupService;
import com.cg.service.CategoryService;
import com.cg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cp/products")
public class CPProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    private String folderName = "/upload/product/";

    @GetMapping("")
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/product/list");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/product/add");

        modelAndView.addObject("product", new Product());
        modelAndView.addObject("productForm", new ProductForm());

        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
        modelAndView.addObject("categoryGroups", categoryGroups);

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/product/add");

//        MultipartFile multipartFile = productForm.getAvatar();
//        String fileName = multipartFile.getOriginalFilename();
//
//        try {
//            FileCopyUtils.copy(productForm.getAvatar().getBytes(), new File(folderName + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Product product = new Product();
//        product.setName(productForm.getName());
//        product.setCategoryGroup(productForm.getCategoryGroup());
//        product.setPrice(productForm.getPrice());
//        product.setQuantity(productForm.getQuantity());
//        product.setDescription(productForm.getDescription());
        product.setAvatar("fileName");

        productService.save(product);

        modelAndView.addObject("product", new Product());
        modelAndView.addObject("productForm", new ProductForm());

        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
        modelAndView.addObject("categoryGroups", categoryGroups);

        return modelAndView;
    }
}
