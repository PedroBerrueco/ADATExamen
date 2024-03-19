package com.pberrueco.ADATExamen.repository;

import com.pberrueco.ADATExamen.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name); //Para buscar por nombre

    List<Product> findProductsByStockOrderByStock(Integer stock); //Para buscar por Integer

}
