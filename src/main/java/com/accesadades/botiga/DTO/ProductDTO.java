package com.accesadades.botiga.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDTO {
    private Long productId;
    private String name;
    private SubcategoriaDTO subcategoria;
    private String description;
    private String company;
    private float price;
    private long units;
    private CategoriaDTO categoria;
}
