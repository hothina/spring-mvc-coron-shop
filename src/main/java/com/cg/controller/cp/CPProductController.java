package com.cg.controller.cp;


import com.cg.model.Category;
import com.cg.model.CategoryGroup;
import com.cg.model.Product;
import com.cg.model.ProductForm;
import com.cg.service.CategoryGroupService;
import com.cg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cp/products")
public class CPProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    private final String folderUpload = "/upload/product/";
    private final String uploadLocal = "D:\\module_4\\CASE_STUDY\\spring-mvc-coron-shop\\src\\main\\webapp\\upload\\product\\";

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

    @GetMapping("/edit{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/product/edit");
//        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
//        modelAndView.addObject("categoryGroups", categoryGroups);

//        Optional<Product> product = productService.findById(id);
//        modelAndView.addObject("product", product.get());

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute("product") Product product, HttpServletRequest request, @ModelAttribute("productForm") ProductForm productForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cp/product/add");

        String uploadRootPath = request.getServletContext().getRealPath(folderUpload);


        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdir();
        }

        MultipartFile multipartFile = productForm.getFileImage();
        String fileName = multipartFile.getOriginalFilename();

        try {
            File serverFile = new File(uploadRootPath + fileName);
            File localFile = new File(uploadLocal + fileName);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(multipartFile.getBytes());
            stream.close();

            BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(localFile));
            streamLocal.write(multipartFile.getBytes());
            streamLocal.close();

            product.setAvatar(fileName);
            productService.save(product);
        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("product", new Product());
        modelAndView.addObject("productForm", new ProductForm());

        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
        modelAndView.addObject("categoryGroups", categoryGroups);

        return modelAndView;
    }
}
