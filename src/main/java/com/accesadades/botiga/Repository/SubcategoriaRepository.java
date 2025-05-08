package com.accesadades.botiga.Repository;
import com.accesadades.botiga.Model.Subcategoria;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {
    Set<Subcategoria> findByCategoria_Id(Long idCategoria);
    Optional<Subcategoria> findByDescription(String description);
    Optional<Subcategoria> findByNombre(String nombre);
    
}