package com.scaler.productservicespringboot.repository;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public Product saveProduct(Product product){
        //connect to mysql db
        //execute the query, insert into product table
        return null;
    }
    public List<Product> getAllProducts(){
        //connect to mysql db
        //execute the query, select all product table
        return new ArrayList<Product>();
    }
}
