package com.pberrueco.ADATExamen.controller;

import com.pberrueco.ADATExamen.model.Product;
import com.pberrueco.ADATExamen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // GET AL LIST
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}") //GET ONE BY ID
    public ResponseEntity<Optional<Product>> getById(@PathVariable Long id) {
        Optional<Product> product = productService.getOne(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name") //GET ONE BY NAME
    public ResponseEntity<List<Product>> searchName(@RequestParam String name) {
        List<Product> products = productService.searchByName(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/integer") //GET ONE BY INTEGER
    public ResponseEntity<List<Product>> searchInteger(@RequestParam Integer integer) {
        List<Product> products = productService.searchByInteger(integer);
        return ResponseEntity.ok(products);
    }

    @PostMapping //POST ONE
    public ResponseEntity<Product> save(@RequestBody Product book){
        Product productNew = productService.saveOne(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productNew);
    }

    @PutMapping("/{id}") //PUT ONE BY ID
    public ResponseEntity<Product> update(@RequestBody Product product){
        Product productNew = productService.updateOne(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productNew);
    }

    @DeleteMapping("/{id}") //DELETE ON BY ID
    public ResponseEntity<String> delete(@PathVariable Long id) {
        productService.deleteOne(id);
        String mensaje = id + "-> ITEM DELETED";
        return ResponseEntity.ok().body(mensaje);
    }

}
