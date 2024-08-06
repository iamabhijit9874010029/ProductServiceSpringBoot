package com.scaler.productservicespringboot.repository;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product getProductByNameAndCategory(String productName, String category);
    List<Product> getProductsByDescription(String description);
}
