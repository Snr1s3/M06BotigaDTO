package com.accesadades.botiga.Service;

import com.accesadades.botiga.Repository.SubcategoriaRepository;
import com.accesadades.botiga.Model.Subcategoria;
import com.accesadades.botiga.DTO.SubcategoriaDTO;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private BotigaMapper mapper;

    @Override
    public SubcategoriaDTO save(SubcategoriaDTO subcategoriaDTO) {
        Subcategoria entity = mapper.toEntity(subcategoriaDTO);
        Subcategoria saved = subcategoriaRepository.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public Set<SubcategoriaDTO> findAll() {
        return subcategoriaRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<SubcategoriaDTO> findById(Long id) {
        return subcategoriaRepository.findById(id)
                .map(mapper::toDTO);
    }

    @Override
    public Optional<SubcategoriaDTO> findByDescSubcategoria(String desc) {
        return subcategoriaRepository.findByDescSubcategoria(desc)
                .map(mapper::toDTO);
    }

    @Override
    public Set<SubcategoriaDTO> findAllByCategoriaId(Long idCategoria) {
        return subcategoriaRepository.findByCategoria_Id(idCategoria).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean delete(Long id) {
        if (subcategoriaRepository.existsById(id)) {
            subcategoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(SubcategoriaDTO subcategoriaDTO) {
        if (subcategoriaDTO.getId() == null || !subcategoriaRepository.existsById(subcategoriaDTO.getId())) {
            return false;
        }
        Subcategoria updated = mapper.toEntity(subcategoriaDTO);
        subcategoriaRepository.save(updated);
        return true;
    }
}
