package com.gopikumar.productcatalogservice.controllers;

import com.gopikumar.productcatalogservice.dtos.ProductDTO;
import com.gopikumar.productcatalogservice.models.Product;
import com.gopikumar.productcatalogservice.services.IProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ImageProducer;

@RestController
public class ProductController {

    IProductServices productServices;

    public ProductController(IProductServices iProductServices) {
        this.productServices = iProductServices;
    }

    @PostMapping("/products")
    ProductDTO CreateProduct(@RequestBody ProductDTO productDTO){

        ProductDTO productResponseDTO=new ProductDTO();
      Product product=new Product();
        productServices.createProduct(product);
    return productResponseDTO;
    }
    @GetMapping("products/{id}")
   ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        ProductDTO productResponseDTO=new ProductDTO();
        if(id<1){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product=productServices.getProductById(id);
        if(product==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDTO productDTO=product.covert(product);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }
    @GetMapping("/products")
    String getAllproducts(){
        return  "Hello World";
    }
//    List<ProductResponseDTO>getAllProducts(){
//        List<ProductResponseDTO> products=new ArrayList<>();
//        return  products;
//    }
}
