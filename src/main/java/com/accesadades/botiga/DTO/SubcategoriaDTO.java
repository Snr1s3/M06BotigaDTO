package com.accesadades.botiga.DTO;

import lombok.Data;

@Data
public class SubcategoriaDTO {
    private String name;
    private String desc_Subcategoria;
    private String status_Subcategoria;
    private CategoriaDTO categoria;
}
