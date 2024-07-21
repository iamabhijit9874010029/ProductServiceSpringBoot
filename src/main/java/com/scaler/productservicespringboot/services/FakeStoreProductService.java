package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.models.Product;

import java.util.List;

public class FakeStoreProductService implements  ProductService{
    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
