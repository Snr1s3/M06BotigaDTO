package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    Set<Product> findByNameAndPrice(String name, float price);

    Set<Product> findBySubcategory_Id(Long idSubcategoria);

    Set<Product> findBySubcategory_Category_Id(Long idCategoria);
}
