package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;
<<<<<<< Updated upstream
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Mapper.ProductMapper;

import java.util.Set;
import java.util.stream.Collectors;
=======
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Repository.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
>>>>>>> Stashed changes

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
<<<<<<< Updated upstream
    private ProductMapper productMapper;

    @Override
    public Set<ProductDTO> findAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public ProductDTO findProductsByName(String name) {
        Product product = productRepository.findByName(name);
        return productMapper.toDTO(product);
    }

    @Override
    public Set<ProductDTO> findAllProductsBySubcategory(String subcategory) {
        return null;
    }

    @Override
    public void increasePrice(Product product) {
=======
    private CategoriaRepository categoryRepository;

    @Autowired
    private SubcategoriaRepository subcategoryRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product entity) {
        if (entity.getSubcategory() == null || 
            entity.getSubcategory().getCategory() == null || 
            !categoryRepository.existsById(entity.getSubcategory().getCategory().getId())) {
            throw new IllegalArgumentException("No existeix la categoria especificada.");
        }
        if (!subcategoryRepository.existsById(entity.getSubcategory().getId())) {
            throw new IllegalArgumentException("No existeix la subcategoria especificada.");
        }

        return productRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
>>>>>>> Stashed changes
    }

    @Override
    public ProductDTO findProductsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductsByName'");
    }

    @Override
    public Set<ProductDTO> findAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllProducts'");
    }
}

