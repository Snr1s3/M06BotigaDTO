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
    date = "2025-04-24T18:50:49+0200",
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
        productDTO.setProductId( producte.getProductId() );
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
        product.setProductId( dto.getProductId() );
        product.setUnits( dto.getUnits() );

        return product;
    }

    @Override
    public CategoriaDTO toDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId( categoria.getId() );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( dto.getId() );

        return categoria;
    }

    @Override
    public SubcategoriaDTO toDTO(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }

        SubcategoriaDTO subcategoriaDTO = new SubcategoriaDTO();

        subcategoriaDTO.setId( subcategoria.getId() );

        return subcategoriaDTO;
    }

    @Override
    public Subcategoria toEntity(SubcategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setId( dto.getId() );

        return subcategoria;
    }
}
