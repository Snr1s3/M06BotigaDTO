package com.accesadades.botiga.Service;
import java.util.Optional;
import java.util.Set;
import com.accesadades.botiga.DTO.SubcategoriaDTO;

public interface SubcategoriaService {
    SubcategoriaDTO save(SubcategoriaDTO subcategoriaDTO);
    Set<SubcategoriaDTO> findAll();
    Optional<SubcategoriaDTO> findById(Long id);
    Optional<SubcategoriaDTO> findByDescSubcategoria(String desc);
    Set<SubcategoriaDTO> findAllByCategoriaId(Long idCategoria);
    boolean delete(Long id);
    boolean update(SubcategoriaDTO subcategoriaDTO);
}