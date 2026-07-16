package com.gopikumar.productcatalogservice.services;

import com.gopikumar.productcatalogservice.models.Product;
import com.gopikumar.productcatalogservice.models.State;
import com.gopikumar.productcatalogservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StorageProductService")

public class StorageProductServices implements IProductServices{

private ProductRepository productRepository;
@Autowired
public StorageProductServices(ProductRepository productRepository) {
    this.productRepository = productRepository;
}
    @Override

    public Product getProductById(Long id) {
        Optional<Product>optionalProduct=productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;

        // or we can write instead of if else -> return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product input) {
    Optional<Product>optionalProduct=productRepository.findById(input.getId());
    if(optionalProduct.isEmpty()){
        return productRepository.save(input);

    }
    else{
        return null;
    }

    }

    @Override
    public Product replacedProduct(Product input, Long productId) {
        Optional<Product>optionalProduct=productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            return null;
        }
        else{
            input.setId(productId);


            return productRepository.save(input);
        }

    }
    public boolean deleteProduct(Long id){
    Optional<Product> optionalProduct=productRepository.findById(id);
    if(optionalProduct.isEmpty()){
        return false;
    }
    else{
        Product product=optionalProduct.get();
        if(product.getState().equals(State.ACTIVE)){
            product.setState(State.INACTIVE);
            productRepository.save(product);
        }

    }
    return true;
    }
}
