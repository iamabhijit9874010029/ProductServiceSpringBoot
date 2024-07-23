package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.dto.ProductResponseDTO;
import com.scaler.productservicespringboot.exceptions.DBNotFoundException;
import com.scaler.productservicespringboot.exceptions.DBTimeOutException;
import com.scaler.productservicespringboot.exceptions.ProductNotFoundException;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.FakeStoreProductService;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponseDTO getSingleProduct(@PathVariable("id") int id) {
        try {
            Product product = productService.getSingleProduct(id);
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(product);
            productResponseDTO.setResponseMessage("Success");
            return productResponseDTO;
        }
        catch (ProductNotFoundException pnfe) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(pnfe.getMessage()+" exception type - 1");
            return productResponseDTO;
        }
        catch (DBNotFoundException dbnfe){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbnfe.getMessage()+" exception type - 2");
            return productResponseDTO;
        }
        catch (DBTimeOutException dbtoe){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbtoe.getMessage()+" exception type - 3");
            return productResponseDTO;
        }
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStoreRequestDTO fakeStoreRequestDTO){
        Product saveProduct = productService.addProduct(fakeStoreRequestDTO);
        return saveProduct;
    }
}
