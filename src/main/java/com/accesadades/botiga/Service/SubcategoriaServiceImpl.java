package com.accesadades.botiga.Service;

import com.accesadades.botiga.Repository.SubcategoriaRepository;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private BotigaMapper categoriaMapper;

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
