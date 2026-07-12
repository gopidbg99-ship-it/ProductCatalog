package com.gopikumar.productcatalogservice.models;

import com.gopikumar.productcatalogservice.dtos.CategoryDTO;
import com.gopikumar.productcatalogservice.dtos.FakestoreProductDTO;
import com.gopikumar.productcatalogservice.dtos.ProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product  extends BaseModal{
    private  String name;
    private String description;
    private Double price;
    private String inageUrl;
    @ManyToOne(cascade = CascadeType.ALL)
    private  Category category;

    public FakestoreProductDTO convertToFakeStoreproduct(){
        FakestoreProductDTO fakestoreProductDTO=new FakestoreProductDTO();
        fakestoreProductDTO.setId(this.getId());
        fakestoreProductDTO.setTitle(this.getName());
        fakestoreProductDTO.setPrice(this.getPrice());
        fakestoreProductDTO.setDescription(this.getDescription());
        fakestoreProductDTO.setImage(this.getInageUrl());
        if(this.getCategory()!=null){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(this.getCategory().getId());
            categoryDTO.setName(this.getCategory().getName());
            categoryDTO.setDescription(this.getCategory().getDescription());

            fakestoreProductDTO.setCategory(categoryDTO);

        }
        return fakestoreProductDTO;
    }

    public ProductDTO covert(){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setPrice(this.getPrice());
        productDTO.setDescription(this.getDescription());
        productDTO.setImageUrl(this.getInageUrl());
        if(this.getCategory()!=null){
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setName(this.getCategory().getName());
            categoryDTO.setId(this.getCategory().getId());
            categoryDTO.setDescription(this.getCategory().getDescription());
            productDTO.setCategory(categoryDTO);
        }

        return  productDTO;

    }
}
