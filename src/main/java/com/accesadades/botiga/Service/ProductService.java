package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;

import java.util.Set;

public interface ProductService extends BotigaService<Product, Long> {
    Set<ProductDTO> findAllProducts();
    ProductDTO findProductsByName(String name);
    Set<ProductDTO> findAllProductsBySubcategory(String subcategory);
}

