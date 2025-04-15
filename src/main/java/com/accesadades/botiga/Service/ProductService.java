package com.accesadades.botiga.Service;

import java.util.Set;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.DTO.ProductDTO;

<<<<<<< Updated upstream
import java.util.Set;

public interface ProductService {
    Set<ProductDTO> findAllProducts();
    ProductDTO findProductsByName(String name);
    Set<ProductDTO> findAllProductsBySubcategory(String subcategory);
    void increasePrice(Product product);
=======
public interface ProductService extends BotigaService<Product, Long> {

    ProductDTO findProductsByName(String name);
   /* Set<ProductDTO> findAllProducts();
    ProductDTO findProductsByName(String name);
    Set<ProductDTO> findAllProductsBySubcategory(String subcategory);*/

    Set<ProductDTO> findAllProducts();
>>>>>>> Stashed changes
}
