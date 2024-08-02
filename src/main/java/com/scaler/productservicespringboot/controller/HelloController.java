package com.scaler.productservicespringboot.controller;

import com.scaler.productservicespringboot.dto.ErrorResponseDTO;
import com.scaler.productservicespringboot.models.Product;
import com.scaler.productservicespringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    @Qualifier("RealProductService")
    ProductService productService;

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable("name") String name) throws Exception {

        List<Product> productList = productService.getAllProducts();
        return "Hello " + name + " " + productList.size();
    }

    @GetMapping("hello")
    public String sayHelloEx() throws Exception {

        throw new Exception();
    }

    //to handle the exception in the controller itself instead of using global controller
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralException(Exception errorObject) {

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrorMessage("General exception : "+errorObject.getMessage());

        ResponseEntity<ErrorResponseDTO> responseEntity = new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);

        return responseEntity;
    }
}
