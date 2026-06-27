package com.gopikumar.productcatalogservice.models;

import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.List;

@Getter
@Setter
public class Category extends BaseModal {

    private  String name;
    private String description;
    private List<Product> products;

}
