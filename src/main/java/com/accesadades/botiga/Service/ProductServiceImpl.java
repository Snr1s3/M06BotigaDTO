package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;
//import com.accesadades.botiga.Mapper.BotigaMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //@Autowired
    //private BotigaMapper productMapper;
    /*
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
*/
    @Override
    public Set<ProductDTO> findAllProductsBySubcategoria(int idCategoria) {
        return productRepository.findBySubcategoria(idCategoria).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toSet());
    }

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
        if (entity.getCategory() == null || !categoryRepository.existsById(entity.getCategory().getId())) {
            throw new IllegalArgumentException("No existeix la categoria especificada.");
        }
        if (entity.getSubcategory() == null || !subcategoryRepository.existsById(entity.getSubcategory().getId())) {
            throw new IllegalArgumentException("No existeix la subcategoria especificada.");
        }
        return productRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
