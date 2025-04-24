package com.accesadades.botiga.Service;
import java.util.Optional;
import java.util.Set;

public interface BotigaService<T, ID>{
    Set<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
}