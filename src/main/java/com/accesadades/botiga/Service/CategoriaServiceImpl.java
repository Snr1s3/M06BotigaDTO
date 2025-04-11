package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.Set;
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private BotigaMapper categoriaMapper;
    /*
    @Override
    public Set<CategoriaDTO> findAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public CategoriaDTO findCategoriasByName(String name) {
        Categoria categoria = categoriaRepository.findByName(name);
        return categoriaMapper.toDTO(categoria);
    }

    @Override
    public Set<CategoriaDTO> findAllCategoriasBySubcategoria(String subcategoria) {
        return categoriaRepository.findBySubcategoria(subcategoria).stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toSet());
    }*/

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria entity) {
        return categoriaRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findByDescCategoria(String desc) {
        return categoryRepository.findByDescCategoria(desc);
    }
}