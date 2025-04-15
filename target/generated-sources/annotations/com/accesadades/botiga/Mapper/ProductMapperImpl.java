package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoryDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-15T16:47:34+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setSubcategory( subcategoriaToSubcategoryDTO( product.getSubcategory() ) );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setCompany( product.getCompany() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setUnits( product.getUnits() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setSubcategory( subcategoryDTOToSubcategoria( productDTO.getSubcategory() ) );
        product.setCompany( productDTO.getCompany() );
        product.setDescription( productDTO.getDescription() );
        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );
        product.setUnits( productDTO.getUnits() );

        return product;
    }

    protected SubcategoryDTO subcategoriaToSubcategoryDTO(Subcategoria subcategoria) {
        if ( subcategoria == null ) {
            return null;
        }

        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();

        subcategoryDTO.setName( subcategoria.getName() );

        return subcategoryDTO;
    }

    protected Subcategoria subcategoryDTOToSubcategoria(SubcategoryDTO subcategoryDTO) {
        if ( subcategoryDTO == null ) {
            return null;
        }

        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setName( subcategoryDTO.getName() );

        return subcategoria;
    }
}
