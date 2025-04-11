package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository categoriaRepository;

    @Autowired
    private BotigaMapper categoriaMapper;
    /*
    @Override
    public Set<SubcategoriaDTO> findAllSubcategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public SubcategoriaDTO findSubcategoriasByName(String name) {
        Subcategoria subcategoria = categoriaRepository.findByName(name);
        return categoriaMapper.toDTO(subcategoria);
    }

    @Override
    public Set<SubcategoriaDTO> findAllSubcategoriasBySubcategoria(String subcategoria) {
        return categoriaRepository.findBySubcategoria(subcategoria).stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toSet());
    }*/

    @Override
    public List<Subcategoria> findAll() {
        return subcategoriaRepository.findAll();
    }

    @Override
    public Optional<Subcategoria> findById(Long id) {
        return subcategoriaRepository.findById(id);
    }

    @Override
    public Subcategoria save(Subcategoria entity) {
        return subcategoriaRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        subcategoriaRepository.deleteById(id);
    }
}