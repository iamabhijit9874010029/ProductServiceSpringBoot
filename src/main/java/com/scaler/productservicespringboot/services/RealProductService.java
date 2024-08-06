package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("RealProductService")
public class RealProductService implements  ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getSingleProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product addProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        return null;
    }
}
