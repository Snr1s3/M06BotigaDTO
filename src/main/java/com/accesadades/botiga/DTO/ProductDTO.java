package com.accesadades.botiga.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private String company;
    private float price;
    private long units;
}
