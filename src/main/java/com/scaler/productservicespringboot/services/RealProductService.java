package com.scaler.productservicespringboot.services;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return productRepository.getAllProducts();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.saveProduct(product);
    }



    @Override
    public Product addProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        return null;
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        List<Product> ProductsFromDB = productRepository.getAllProducts();

        //core logic for filter products, with whether the products contain searchtext or not
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : ProductsFromDB) {
            if(product.getName().contains(searchText)){
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
}
