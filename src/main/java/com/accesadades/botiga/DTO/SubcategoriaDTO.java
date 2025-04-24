package com.accesadades.botiga.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SubcategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long categoriaId;
}
