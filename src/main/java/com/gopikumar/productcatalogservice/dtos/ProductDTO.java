package com.gopikumar.productcatalogservice.dtos;

import com.gopikumar.productcatalogservice.models.Category;
import com.gopikumar.productcatalogservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTO {

private Long id;
private String name;
private String description;
private CategoryDTO category;
private Double price;
private  String imageUrl;

public Product convertToProduct(ProductDTO productDTO) {
    Product product = new Product();
    product.setId(productDTO.getId());
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    product.setInageUrl(productDTO.getImageUrl());

    System.out.println("Sending Image = " + productDTO.getImageUrl());
    if (productDTO.getCategory() != null) {
        Category category1 = new Category();
        category1.setName(productDTO.getCategory().getName());
        category1.setId(productDTO.getCategory().getId());
        category1.setDescription(productDTO.getCategory().getDescription());
        product.setCategory(category1);

    }

    return product;
}
}
