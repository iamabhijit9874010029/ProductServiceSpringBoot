package com.scaler.productservicespringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    private String title;
    //it is the inverse of the same relation between Product and Category
    //telling spring that this attribute is already handled in product table with category column
//    @OneToMany(mappedBy = "category")
//    private List<Product> products;
}
