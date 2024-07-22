package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.FakeStoreProductService;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStoreRequestDTO fakeStoreRequestDTO){
        Product saveProduct = productService.addProduct(fakeStoreRequestDTO);
        return saveProduct;
    }
}
