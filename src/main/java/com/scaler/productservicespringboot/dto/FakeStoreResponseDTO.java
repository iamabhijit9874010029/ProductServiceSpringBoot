package com.scaler.productservicespringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private int id;
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
}
