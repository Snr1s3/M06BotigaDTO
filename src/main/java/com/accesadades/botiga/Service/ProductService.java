package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.DTO.ProductDTO;

import java.util.Set;

public interface ProductService {
    Set<ProductDTO> findAllProducts();
    ProductDTO findProductsByName(String name);
    Set<ProductDTO> findAllProductsBySubcategory(String subcategory);
    void increasePrice(Product product);
}
