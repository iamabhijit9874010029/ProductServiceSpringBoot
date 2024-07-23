package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStorePOSTResponseDTO;
import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.dto.FakeStoreResponseDTO;
import com.scaler.productservicespringboot.exceptions.ProductNotFoundException;
import com.scaler.productservicespringboot.models.Category;
import com.scaler.productservicespringboot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements  ProductService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(int id) throws ProductNotFoundException {
        FakeStoreResponseDTO response = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDTO.class);

        if(response == null){
            throw new ProductNotFoundException("Product id "+ id + " not found");
        }

        Product product = response.toProduct();

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDTO[] responsesArray = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);

        List<Product> productList = new ArrayList<Product>();

        for (FakeStoreResponseDTO response : responsesArray) {
            Product product = response.toProduct();
            productList.add(product);
        }

        return productList;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product addProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStorePOSTResponseDTO addProductResponse = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreRequestDTO, FakeStorePOSTResponseDTO.class);

        Product product = addProductResponse.toProduct();

        return product;
    }

}
