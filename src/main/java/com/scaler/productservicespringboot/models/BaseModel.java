package com.scaler.productservicespringboot.models;

import jakarta.persistence.*;

import jakarta.persistence.Id;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.Date;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    private Boolean isDeleted;
}
