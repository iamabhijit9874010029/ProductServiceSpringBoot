package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealProductService implements  ProductService{
    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}