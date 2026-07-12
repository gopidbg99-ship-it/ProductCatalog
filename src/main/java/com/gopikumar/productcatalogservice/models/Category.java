package com.gopikumar.productcatalogservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModal {

    private  String name;
    private String description;
    @OneToMany(mappedBy= "category")
    private List<Product> products;

}
