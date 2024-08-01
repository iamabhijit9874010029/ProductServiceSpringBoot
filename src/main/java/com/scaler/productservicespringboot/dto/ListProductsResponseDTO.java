package com.scaler.productservicespringboot.dto;

import com.scaler.productservicespringboot.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListProductsResponseDTO {
    private List<Product> productList;
    private String responseMessage;
}
