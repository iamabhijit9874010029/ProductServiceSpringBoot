package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.exceptions.DBNotFoundException;
import com.scaler.productservicespringboot.exceptions.DBTimeOutException;
import com.scaler.productservicespringboot.exceptions.ProductNotFoundException;
import com.scaler.productservicespringboot.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(int id) throws ProductNotFoundException, DBNotFoundException, DBTimeOutException;
    List<Product> getAllProducts();

    //to create objects in your own db
    Product addProduct(Product product);

    //to create objects in fakestore db
    Product addProduct(FakeStoreRequestDTO fakeStoreRequestDTO);
}
