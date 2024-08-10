package com.scaler.productservicespringboot.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //IDENTITY => Auto Increment
//    1
//    2
//    3
//    4
//    last+1=>5

    //AUTO => automatically assign values, but it should be unique but can be anything
//    1
//    55
//    56
//    90
//    92
//    100
//    last+random=>105
    private long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
