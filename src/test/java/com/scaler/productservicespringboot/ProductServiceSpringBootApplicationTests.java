package com.scaler.productservicespringboot;

import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceSpringBootApplicationTests {

    ProductRepository productRepository;

    @Autowired
    ProductServiceSpringBootApplicationTests(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void HQLqueryForGetEverything() {
        List<Product> products = productRepository.giveEverythingFromProductTable();
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    void HQLqueryForGetEverythingWhereCategory() {
        List<Product> products = productRepository.giveEverythingFromProductTableWhereCategoryNameIs("laptop");

        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    void SQLqueryForGetEverythingWhereProduct() {
        List<Product> products = productRepository.SQLqueryForgiveEverythingFromProductTableWhereCategoryNameIs("mobile");

        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
