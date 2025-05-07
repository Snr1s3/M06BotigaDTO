package com.accesadades.botiga.Service;
import com.accesadades.botiga.DTO.ProductDTO;

import java.util.Optional;
import java.util.Set;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    Set<ProductDTO> findAll();
    Optional<ProductDTO> findById(Long id);
    Set<ProductDTO> findProductsByName(String name);
    // Set<ProductDTO> findAllBySubcategoryId(Long idSubcategoria);
    Set<ProductDTO> findAllByCategoriaNom(String nombreCategoria);
    boolean updatePrice(Long id, Long nouPreu);
    boolean delete(Long id);
}