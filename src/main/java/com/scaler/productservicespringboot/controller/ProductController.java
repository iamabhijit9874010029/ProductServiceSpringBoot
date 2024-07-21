package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") int id){

        return null;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return new ArrayList<>();
    }
}
