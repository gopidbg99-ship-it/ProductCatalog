package com.gopikumar.productcatalogservice.repositories;

import com.gopikumar.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import com.gopikumar.productcatalogservice.models.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
@Test
@Transactional
    public void testFetchType(){
    Optional<Category> optionalCategory=categoryRepository.findById(1L);
    if(optionalCategory.isPresent()){
        Category category=optionalCategory.get();
      //  System.out.println(category.getName());

        for (Product  product : category.getProducts()) {
            System.out.println(product.getName());
        }
    }

}
}