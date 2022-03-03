package com.cg.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private MultipartFile fileImage;

    public ProductForm() {
    }

    public ProductForm(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
    }
}
