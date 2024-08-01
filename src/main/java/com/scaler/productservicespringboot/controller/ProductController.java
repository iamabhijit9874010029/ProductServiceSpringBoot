package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.dto.FakeStoreRequestDTO;
import com.scaler.productservicespringboot.dto.ListProductsResponseDTO;
import com.scaler.productservicespringboot.dto.ProductResponseDTO;
import com.scaler.productservicespringboot.exceptions.DBNotFoundException;
import com.scaler.productservicespringboot.exceptions.DBTimeOutException;
import com.scaler.productservicespringboot.exceptions.ProductNotFoundException;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.FakeStoreProductService;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("FakeStoreProductService")        
    ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getSingleProduct(@PathVariable("id") int id) {
        try {
            Product product = productService.getSingleProduct(id);
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(product);
            productResponseDTO.setResponseMessage("Success");

            ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.OK);

            return responseEntity;
        }
        catch (ProductNotFoundException pnfe) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(pnfe.getMessage()+" exception type - 1");

            ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

            return responseEntity;
        }
        catch (DBNotFoundException dbnfe){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbnfe.getMessage()+" exception type - 2");

            ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

            return responseEntity;
        }
        catch (DBTimeOutException dbtoe){
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProduct(null);
            productResponseDTO.setResponseMessage(dbtoe.getMessage()+" exception type - 3");

            ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

            return responseEntity;
        }
    }

    @GetMapping("/products")
    public ResponseEntity<ListProductsResponseDTO> getAllProducts(){
        try{
            List<Product> products = productService.getAllProducts();

            ListProductsResponseDTO responseDTO = new ListProductsResponseDTO();
            responseDTO.setProductList(products);
            responseDTO.setResponseMessage("Success");

            ResponseEntity<ListProductsResponseDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.OK);
            return responseEntity;
        }catch (Exception e){
            ListProductsResponseDTO responseDTO = new ListProductsResponseDTO();
            responseDTO.setProductList(new ArrayList<>());
            responseDTO.setResponseMessage("Failure");

            ResponseEntity<ListProductsResponseDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody FakeStoreRequestDTO fakeStoreRequestDTO){
        Product saveProduct = productService.addProduct(fakeStoreRequestDTO);
        return saveProduct;
    }
}
