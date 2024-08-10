package com.scaler.productservicespringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    private int id;
    private String title;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
