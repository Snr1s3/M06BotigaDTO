package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByDescCategoria(String desc);
}
