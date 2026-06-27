package com.gopikumar.productcatalogservice.dtos;

import com.gopikumar.productcatalogservice.models.Category;
import com.gopikumar.productcatalogservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    private String category;

   public Product from(FakestoreProductDTO fakestoreProductDTO){
       Product product=new Product();
       product.setId(fakestoreProductDTO.getId());
       product.setName(fakestoreProductDTO.getTitle());
       product.setDescription(fakestoreProductDTO.getDescription());
       product.setInageUrl(fakestoreProductDTO.getImage());
       product.setPrice(fakestoreProductDTO.getPrice());
       Category category=new Category();
       category.setName(fakestoreProductDTO.getCategory());
       product.setCategory(category);

       return  product;


   }
}
