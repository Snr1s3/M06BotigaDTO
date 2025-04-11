package com.accesadades.botiga.Service;

import java.util.Locale.Category;

import com.accesadades.botiga.Model.Categoria;
import java.util.Optional;

public interface CategoriaService extends BotigaService<Categoria, Long> {
    Optional<Category> findByDescCategoria(String desc);
}
