package com.accesadades.botiga.Service;
import com.accesadades.botiga.DTO.CategoriaDTO;
import java.util.Optional;
import java.util.Set;

public interface CategoriaService {
    CategoriaDTO save(CategoriaDTO categoriaDTO);
    Set<CategoriaDTO> findAll();
    Optional<CategoriaDTO> findById(Long id);
    Optional<CategoriaDTO> findByDescCategoria(String desc);
    boolean delete(Long id);
    boolean update(CategoriaDTO categoriaDTO);
}