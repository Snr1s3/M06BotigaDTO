package com.accesadades.botiga.Service;

import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private BotigaMapper mapper;

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        if (categoriaRepository.findByDescription(categoriaDTO.getDescription()).isPresent()) {
            throw new IllegalArgumentException("La categoría ya existe con esa descripción.");
        }
    
        System.out.println(categoriaDTO);
        Categoria categoria = mapper.toEntity(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return mapper.toDTO(savedCategoria);
    }
    
    @Override
    public boolean update(CategoriaDTO categoriaDTO) {
        if (categoriaDTO == null) {
            return false;
        }
        Optional<Categoria> existing = categoriaRepository.findByDescription(categoriaDTO.getDescription());
        if (existing.isPresent()) {
            Categoria toUpdate = existing.get();
            toUpdate.setStatus(categoriaDTO.getStatus());
            categoriaRepository.save(toUpdate);
            return true;
        }
    
        return false;
    }
    

    @Override
    public Set<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(mapper::toDTO) 
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) {
        return categoriaRepository.findById(id)
                .map(mapper::toDTO);
    }

    @Override
    public Optional<CategoriaDTO> findByDescCategoria(String desc) {
        return categoriaRepository.findByDescription(desc)
                .map(mapper::toDTO);
    }

    @Override
    public boolean delete(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}