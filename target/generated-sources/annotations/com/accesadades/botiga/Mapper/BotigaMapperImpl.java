package com.accesadades.botiga.Mapper;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategoria;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T15:41:10+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class BotigaMapperImpl implements BotigaMapper {

    @Autowired
    private SubcategoriaMapperHelper subcategoriaMapperHelper;
    @Autowired
    private ProductMapperHelper productMapperHelper;

    @Override
    public ProductDTO toDTO(Product producte) {
        if ( producte == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCatName( productMapperHelper.getCategoryNameByName( producteCategoriaNombre( producte ) ) );
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

        product.setCategoria( productMapperHelper.getCategoryByName( dto.getCatName() ) );
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

        categoriaDTO.setDescription( categoria.getDescription() );
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

        categoria.setDescription( categoriaDto.getDescription() );
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

        subcategoriaDTO.setCatName( subcategoriaMapperHelper.getCategoryNameByName( subcategoriaCategoriaNombre( subcategoria ) ) );
        subcategoriaDTO.setDescription( subcategoria.getDescription() );
        subcategoriaDTO.setNombre( subcategoria.getNombre() );

        return subcategoriaDTO;
    }

    @Override
    public Subcategoria toEntity(SubcategoriaDTO subcategoriaDto) {
        if ( subcategoriaDto == null ) {
            return null;
        }

        Subcategoria subcategoria = new Subcategoria();

        subcategoria.setCategoria( subcategoriaMapperHelper.getCategoryByName( subcategoriaDto.getCatName() ) );
        subcategoria.setDescription( subcategoriaDto.getDescription() );
        subcategoria.setNombre( subcategoriaDto.getNombre() );

        return subcategoria;
    }

    private String producteCategoriaNombre(Product product) {
        Categoria categoria = product.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        return categoria.getNombre();
    }

    private String subcategoriaCategoriaNombre(Subcategoria subcategoria) {
        Categoria categoria = subcategoria.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        return categoria.getNombre();
    }
}
