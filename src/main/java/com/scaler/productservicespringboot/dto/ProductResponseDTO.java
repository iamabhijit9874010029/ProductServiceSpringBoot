package com.scaler.productservicespringboot.dto;

import com.scaler.productservicespringboot.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Product product;
    private String responseMessage;
}
