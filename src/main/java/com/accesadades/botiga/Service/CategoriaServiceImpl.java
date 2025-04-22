package com.accesadades.botiga.Service;

import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Model.Categoria;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private BotigaMapper categoriaMapper;

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
    public Optional<Categoria> findByDescCategoria(String desc) {
        return categoriaRepository.findByDescCategoria(desc);
    }
}
