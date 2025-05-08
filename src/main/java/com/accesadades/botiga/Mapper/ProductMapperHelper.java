package com.accesadades.botiga.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Repository.CategoriaRepository;
@Component
public class ProductMapperHelper {
    private CategoriaRepository categoriaRepository;
    @Autowired
    public ProductMapperHelper(CategoriaRepository categoriaRepository) {
        this.categoriaRepository= categoriaRepository;
    }

    @Named("getCategoryNameByNameProduct")
    public String getCategoryNameByName(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        return categoriaRepository.findByNombre(name)
                .map(categoria -> categoria.getNombre())
                .orElse(null);
    }

    @Named("getCategoryByNameProduct")
    public Categoria getCategoryByName(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        return categoriaRepository.findByNombre(name)
                .orElse(null);
    }

}