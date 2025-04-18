package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accesadades.botiga.Model.Product;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
    Set<Product> findByNameAndPrice(String name, float price);
}
