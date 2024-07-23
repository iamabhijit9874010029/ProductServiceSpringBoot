package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.dto.ProductResponseDTO;
import com.scaler.productservicespringboot.exceptions.ProductNotFoundException;
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
    public ProductResponseDTO getSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        try {
            Product product = productService.getSingleProduct(id);
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(product);
            productResponseDTO.setResponseMessage("Success");
            return productResponseDTO;
        }
        catch (ProductNotFoundException e) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(e.getMessage());
            return productResponseDTO;
        }
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
