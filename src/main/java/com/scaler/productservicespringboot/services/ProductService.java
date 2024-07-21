package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(int id);
    List<Product> getAllProducts();
}
