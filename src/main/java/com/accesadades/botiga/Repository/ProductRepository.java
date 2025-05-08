    package com.accesadades.botiga.Repository;

    import com.accesadades.botiga.Model.Product;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import java.util.List;
    import java.util.Set;

    @Repository
    public interface ProductRepository extends JpaRepository<Product, Long> {
        
        Product findByName(String name);
        List<Product> findByCategoria_Nombre(String nombreCategoria);
        Set<Product> findByNameAndPrice(String name, float price);
    }
