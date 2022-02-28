package com.cg.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private MultipartFile avatar;

    public ProductForm() {
    }

    public ProductForm(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
