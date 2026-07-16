package com.gopikumar.productcatalogservice.repositories;

import com.gopikumar.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    public List<Product> findProductByPriceBetween(Double low,Double high);

    List<Product> findAllByOrderByPrice();
    @Query("select p.description from Product p where p.id=:id" )
    String getDescriptionWhereIdIs(@Param("id") Long id);


}
