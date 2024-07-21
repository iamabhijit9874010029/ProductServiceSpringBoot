package com.scaler.productservicespringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponse {
    private int id;
    private String title;
    private Integer price;
    private String description;
    private String image;
    private String category;
}
