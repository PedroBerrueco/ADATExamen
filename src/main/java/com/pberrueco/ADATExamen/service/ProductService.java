package com.pberrueco.ADATExamen.service;


import com.pberrueco.ADATExamen.model.Product;
import com.pberrueco.ADATExamen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() { return productRepository.findAll(); }
    public Optional<Product> getOne(Long id){
        return productRepository.findById(id);
    }
    public Product saveOne(Product product){
        return productRepository.save(product);
    }
    public Product updateOne(Product product){
        return productRepository.save(product);
    }
    public void deleteOne(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> searchByName(String name){ return productRepository.findByNameContainingIgnoreCase(name);}
    public List<Product> searchByInteger(Integer integer){ return productRepository.findProductsByStockOrderByStock(integer);}

}
