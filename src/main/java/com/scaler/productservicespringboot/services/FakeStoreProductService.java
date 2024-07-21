package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStoreResponse;
import com.scaler.productservicespringboot.models.Category;
import com.scaler.productservicespringboot.models.Product;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class FakeStoreProductService implements  ProductService{

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product getSingleProduct(int id) {
        FakeStoreResponse response = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponse.class);

        Product product = new Product();

        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice());
        product.setImgUrl(response.getImage());

        Category category = new Category();
        category.setTitle(response.getCategory());

        product.setCategory(category);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponse[] responsesArray = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponse[].class);

        List<Product> productList = new ArrayList<Product>();

        for (FakeStoreResponse response : responsesArray) {
            Product product = new Product();

            product.setId(response.getId());
            product.setName(response.getTitle());
            product.setDescription(response.getDescription());
            product.setPrice(response.getPrice());
            product.setImgUrl(response.getImage());

            Category category = new Category();
            category.setTitle(response.getCategory());

            product.setCategory(category);

            productList.add(product);
        }

        return productList;
    }
}
