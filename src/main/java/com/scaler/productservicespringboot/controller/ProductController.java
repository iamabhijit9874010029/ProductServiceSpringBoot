package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.FakeStoreProductService;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") int id){
        Product product = productService.getSingleProduct(id);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }
}
