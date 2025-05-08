package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Subcategoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {SubcategoriaMapperHelper.class, ProductMapperHelper.class})
public interface BotigaMapper {
    
    @Mapping(source = "categoria.nombre", target = "catName", qualifiedByName = "getCategoryNameByNameProduct")
    ProductDTO toDTO(Product producte);

    @Mapping(source = "catName", target = "categoria", qualifiedByName = "getCategoryByNameProduct")
    Product toEntity(ProductDTO dto);

    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDto);


    
    @Mapping(source = "categoria.nombre", target = "catName", qualifiedByName = "getCategoryNameByName")
    SubcategoriaDTO toDTO(Subcategoria subcategoria);

    @Mapping(source = "catName", target = "categoria", qualifiedByName = "getCategoryByName")
    Subcategoria toEntity(SubcategoriaDTO subcategoriaDto);
}