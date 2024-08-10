package com.scaler.productservicespringboot.dto;

import com.scaler.productservicespringboot.models.Category;
import com.scaler.productservicespringboot.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStorePOSTResponseDTO {
    private long id;
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();

        product.setId(Long.valueOf(this.id));
        product.setName(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImgUrl(this.image);

        Category category = new Category();
        category.setTitle(this.category);

//        product.setCategory(category);

        return product;
    }
}
