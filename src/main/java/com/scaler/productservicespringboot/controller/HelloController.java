package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    @Qualifier("RealProductService")
    ProductService productService;

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        List<Product> productList = productService.getAllProducts();
        return "Hello " + name + " " + productList.size();
    }
}
