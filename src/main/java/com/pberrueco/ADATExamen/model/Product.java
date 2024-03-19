package com.pberrueco.ADATExamen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fav_products") // Aquí estamos eligiendo el nombre de la tabla en la BD  //
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) // Lo ponemos sobre las columnas que no queramos que sean nulas.
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private Integer stock;
}
