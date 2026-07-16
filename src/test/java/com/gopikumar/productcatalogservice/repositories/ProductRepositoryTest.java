package com.gopikumar.productcatalogservice.repositories;

import com.gopikumar.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void testJPAMethod() {
//List<Product> products = productRepository.findAllByOrderByPrice();

        String description=productRepository.getDescriptionWhereIdIs(2L);
//        System.out.println("Size = " + products.size());
//
//        for (Product product : products) {
//        Product product=new Product();
//            System.out.println("Name = " + product.getName());
//            System.out.println("Price = " + product.getPrice());
////        }

        System.out.println(description);

    }

}