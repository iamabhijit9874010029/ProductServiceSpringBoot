package com.scaler.productservicespringboot.repository;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    Integer countProductByPriceLessThan(Double price);
//    SELECT COUNT(*) FROM products p WHERE p.price<value;

    List<Product> getProductByName(String name);

    List<Product> getProductByNameLikeAndDescriptionLikeOrderByPriceDesc(String name, String description);

    List<Product> getProductByCategoryTitle(String categoryTitle);

    @Query("SELECT p FROM Product p")
    List<Product> getAllProducts();
//    SELECT p.name FROM products p JOIN category c ON p.category_id=c.id AND c.name=categoryName;
}
