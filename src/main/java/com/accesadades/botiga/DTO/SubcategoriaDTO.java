package com.accesadades.botiga.DTO;

import lombok.Data;

@Data
public class SubcategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long categoriaId;
}
