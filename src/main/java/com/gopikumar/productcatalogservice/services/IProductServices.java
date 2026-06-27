package com.gopikumar.productcatalogservice.services;

import com.gopikumar.productcatalogservice.models.Product;

import java.util.List;

public interface IProductServices {

    Product getProductById(Long id);

    List<Product> getAllProduct();

    public Product createProduct(Product input);
}
