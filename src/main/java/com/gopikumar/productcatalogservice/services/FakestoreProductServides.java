package com.gopikumar.productcatalogservice.services;

import com.gopikumar.productcatalogservice.dtos.FakestoreProductDTO;
import com.gopikumar.productcatalogservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class FakestoreProductServides implements  IProductServices{

    private RestTemplate restTemplate;
    public FakestoreProductServides(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
//       FakestoreProductDTO fakestoreProductDTO= restTemplate.getForObject("https://fakestoreapi.com/products/{id}",
//                FakestoreProductDTO.class,id);
        ResponseEntity<FakestoreProductDTO> fakestoreProductDTOResponseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakestoreProductDTO.class,id);

        if(fakestoreProductDTOResponseEntity.hasBody()&&fakestoreProductDTOResponseEntity.getStatusCode().equals(
                HttpStatusCode.valueOf(200))){
            return fakestoreProductDTOResponseEntity.getBody().from(fakestoreProductDTOResponseEntity.getBody());
        }
        return  null;
    }

    @Override

    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct(Product input) {
        return null;
    }
}
