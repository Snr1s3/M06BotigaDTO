package com.accesadades.botiga.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDTO {
    private String name;
    private String description;
    private String company;
    private float price;
    private long units;
}
