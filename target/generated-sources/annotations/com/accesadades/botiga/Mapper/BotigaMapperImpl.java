package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T00:31:27+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class BotigaMapperImpl implements BotigaMapper {

    @Override
    public ProductDTO toDTO(Product producte) {
        if ( producte == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCompany( producte.getCompany() );
        productDTO.setDescription( producte.getDescription() );
        productDTO.setName( producte.getName() );
        if ( producte.getPrice() != null ) {
            productDTO.setPrice( producte.getPrice() );
        }
        if ( producte.getUnits() != null ) {
            productDTO.setUnits( producte.getUnits() );
        }

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCompany( dto.getCompany() );
        product.setDescription( dto.getDescription() );
        product.setName( dto.getName() );
        product.setPrice( (long) dto.getPrice() );
        product.setUnits( dto.getUnits() );

        return product;
    }

    @Override
    public CategoriaDTO toDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setDescripcio( categoria.getDescripcio() );
        categoriaDTO.setNombre( categoria.getNombre() );
        categoriaDTO.setStatus( categoria.getStatus() );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setDescripcio( categoriaDto.getDescripcio() );
        categoria.setNombre( categoriaDto.getNombre() );
        categoria.setStatus( categoriaDto.getStatus() );

        return categoria;
    }

    @Override
    public SubcategoriaDTO toDTO(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }

        SubcategoriaDTO subcategoriaDTO = new SubcategoriaDTO();

        subcategoriaDTO.setCategoria( toDTO( subcategoria.getCategoria() ) );
        subcategoriaDTO.setDescripcio( subcategoria.getDescripcio() );
        subcategoriaDTO.setNombre( subcategoria.getNombre() );

        return subcategoriaDTO;
    }

    @Override
    public Subcategoria toEntity(SubcategoriaDTO subcategoriaDto) {
        if ( subcategoriaDto == null ) {
            return null;
        }

        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setCategoria( toEntity( subcategoriaDto.getCategoria() ) );
        subcategoria.setDescripcio( subcategoriaDto.getDescripcio() );
        subcategoria.setNombre( subcategoriaDto.getNombre() );

        return subcategoria;
    }
}
