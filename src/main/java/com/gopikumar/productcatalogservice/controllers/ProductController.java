package com.gopikumar.productcatalogservice.controllers;

import com.gopikumar.productcatalogservice.dtos.ProductDTO;
import com.gopikumar.productcatalogservice.models.Product;
import com.gopikumar.productcatalogservice.services.IProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final RestTemplate restTemplate;
    IProductServices productServices;

    public ProductController(@Qualifier("StorageProductService") IProductServices iProductServices, RestTemplate restTemplate) {
        this.productServices = iProductServices;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products")
    ProductDTO CreateProduct(@RequestBody ProductDTO productDTO){

        ProductDTO productResponseDTO=new ProductDTO();
        Product product1 = productServices.createProduct(productDTO.convertToProduct(productDTO));
      if(product1!=null){
          return product1.covert();
      }
    return productResponseDTO;
    }

    @PutMapping("/products/{productId}")
    ProductDTO updateProduct(@PathVariable("productId")Long productId,@RequestBody ProductDTO productDTO){
        ProductDTO productResponseDTO=new ProductDTO();
        Product product=productServices.replacedProduct(productDTO.convertToProduct(productDTO),productId);

        if(product!=null){
            return product.covert();
        }
        return null;
    }

    @GetMapping("products/{id}")
   ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        ProductDTO productResponseDTO=new ProductDTO();
        if(id<1){
            throw new IllegalArgumentException("Invalid ProductId (Its zero or negative)");
        }
        Product product=productServices.getProductById(id);
        if(product==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDTO productDTO=product.covert();
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }
    @GetMapping("/products")
    List<ProductDTO> getAllproducts(){
        List<ProductDTO>productDTOS=new ArrayList<>();
        List<Product>products=productServices.getAllProduct();
        if(products!=null){
            for(Product product:products){
                productDTOS.add(product.covert());
            }

        }
        return productDTOS;
  }
//    List<ProductResponseDTO>getAllProducts(){
//        List<ProductResponseDTO> products=new ArrayList<>();
//        return  products;
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(Exception exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
