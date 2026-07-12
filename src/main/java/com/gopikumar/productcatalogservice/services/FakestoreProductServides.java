package com.gopikumar.productcatalogservice.services;

import com.gopikumar.productcatalogservice.clents.FakeStoreAPIClient;
import com.gopikumar.productcatalogservice.dtos.FakestoreProductDTO;
import com.gopikumar.productcatalogservice.models.Product;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

public class FakestoreProductServides implements  IProductServices{

    public FakeStoreAPIClient fakeStoreAPIClient;

    public FakestoreProductServides(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public Product getProductById(Long id) {
//       FakestoreProductDTO fakestoreProductDTO= restTemplate.getForObject("https://fakestoreapi.com/products/{id}",
//                FakestoreProductDTO.class,id);
        ResponseEntity<FakestoreProductDTO> fakestoreProductDTOResponseEntity=fakeStoreAPIClient.getForEntity("https://fakestoreapi.com/products/{id}", FakestoreProductDTO.class,id);

        if(fakeStoreAPIClient.validateResponse(fakestoreProductDTOResponseEntity)){
            return fakestoreProductDTOResponseEntity.getBody().from(fakestoreProductDTOResponseEntity.getBody());
        }
        return  null;
    }

    @Override

    public List<Product> getAllProduct() {
        List<Product>products=new ArrayList<>();
       ResponseEntity<FakestoreProductDTO[]> response= fakeStoreAPIClient.getForEntity
               ("https://fakestoreapi.com/products",FakestoreProductDTO[].class);
       if(response.hasBody() && response.getStatusCode().equals(HttpStatusCode.valueOf(200)))
       {
        FakestoreProductDTO[] fakestoreProductDTOS=response.getBody();
        for(FakestoreProductDTO fakestoreProductDTO:fakestoreProductDTOS){
            products.add(fakestoreProductDTO.from(fakestoreProductDTO));
        }
        return products;
       }
        return null;
    }

    @Override
    public Product createProduct(Product input) {
        return null;
    }

    public Product replacedProduct(Product product,Long id){
        FakestoreProductDTO fakestoreProductDTO1=product.convertToFakeStoreproduct();
        ResponseEntity<FakestoreProductDTO> response=
        fakeStoreAPIClient.puttForEntity("https://fakestoreapi.com/products/{id}",product, FakestoreProductDTO.class,id
        );
        if(response.hasBody() && response.getStatusCode().equals(HttpStatusCode.valueOf(200))){
//            FakestoreProductDTO body=response.getBody();
//            return fakestoreProductDTO1.from(fakestoreProductDTO1);
            return product;
        }

        return null;
    }
}
