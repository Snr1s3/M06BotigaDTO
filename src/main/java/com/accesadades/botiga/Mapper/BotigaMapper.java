package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import  com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;

public interface BotigaMapper{
    ProductDTO toDTO(Product producte);

    Product toEntity(ProductDTO dto);

    CategoriaDTO toDTO(Categoria Categoria);

    Categoria toEntity(CategoriaDTO dto);

    SubcategoriaDTO toDTO(Subcategoria producte);

    Subcategoria toEntity(SubcategoriaDTO dto);
}




/*
 * package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "subcategory", target = "subcategory")
    ProductDTO toDTO(Product product);
    @Mapping(source = "subcategory", target = "subcategory")
    Product toEntity(ProductDTO productDTO);
    default String map(SubcategoryDTO subcategoryDTO) {
        if (subcategoryDTO == null) {
            return null;
        }
        return subcategoryDTO.getName();
    }
    default SubcategoryDTO map(String value) {
        if (value == null) {
            return null;
        }
        SubcategoryDTO dto = new SubcategoryDTO();
        dto.setName(value);
        return dto;
    }
}



 */