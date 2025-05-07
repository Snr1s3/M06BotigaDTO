package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Subcategoria;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BotigaMapper {

    ProductDTO toDTO(Product producte);
    Product toEntity(ProductDTO dto);

    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDto);

    SubcategoriaDTO toDTO(Subcategoria subcategoria);
    Subcategoria toEntity(SubcategoriaDTO subcategoriaDto);
}