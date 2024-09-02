package com.scaler.productservicespringboot.repository;

import com.scaler.productservicespringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<Product> getProductsByCategoryTitle(String category);

    //HQL query demo
    @Query("SELECT p FROM Product p")
    List<Product> giveEverythingFromProductTable();

    //HQL query demo
    @Query("SELECT p FROM Product p WHERE p.category.title=:catName")
    List<Product> giveEverythingFromProductTableWhereCategoryNameIs(@Param("catName") String category);

    //SQL query
    @Query(value = "SELECT p.* FROM product AS p JOIN category AS c ON p.category_id=c.id WHERE c.title=:catName", nativeQuery = true)
    List<Product> SQLqueryForgiveEverythingFromProductTableWhereCategoryNameIs(@Param("catName") String catName);
}
