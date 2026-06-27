package com.gopikumar.productcatalogservice.models;

import com.gopikumar.productcatalogservice.dtos.CategoryDTO;
import com.gopikumar.productcatalogservice.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product  extends BaseModal{
    private  String name;
    private String description;
    private Double price;
    private String inageUrl;
    private  Category category;

    public ProductDTO covert(Product product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setPrice(this.getPrice());
        productDTO.setDescription(this.getDescription());
        productDTO.setImageUrl(this.getInageUrl());
        if(product.getCategory()!=null){
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setName(this.getCategory().getName());
            categoryDTO.setId(this.getCategory().getId());
            categoryDTO.setDescription(this.getCategory().getDescription());
            productDTO.setCategory(categoryDTO);
        }

        return  productDTO;

    }
}
