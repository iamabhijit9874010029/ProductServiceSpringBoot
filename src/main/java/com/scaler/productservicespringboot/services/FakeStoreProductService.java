package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStorePOSTResponseDTO;
import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.dto.FakeStoreResponseDTO;
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
    public Product getSingleProduct(int id) {
        FakeStoreResponseDTO response = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDTO.class);

        Product product = convertResponseToProduct(response);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDTO[] responsesArray = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);

        List<Product> productList = new ArrayList<Product>();

        for (FakeStoreResponseDTO response : responsesArray) {
            Product product = convertResponseToProduct(response);
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

        Product product = convertPOSTResponseToProduct(addProductResponse);

        return product;
    }

    private Product convertResponseToProduct(FakeStoreResponseDTO response) {
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

    private Product convertPOSTResponseToProduct(FakeStorePOSTResponseDTO response) {
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
}
