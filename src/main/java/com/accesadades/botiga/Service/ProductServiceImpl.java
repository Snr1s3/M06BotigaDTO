package com.accesadades.botiga.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.Mapper.BotigaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private BotigaMapper botigaMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BotigaMapper mapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return mapper.toDTO(savedProduct);
    }
    

    @Override
    public Set<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id).map(mapper::toDTO);
    }

    @Override
    public Set<ProductDTO> findProductsByName(String name) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            return Set.of();
        }
        return Set.of(mapper.toDTO(product));
    }

    // @Override
    // public Set<ProductDTO> findAllBySubcategoryId(Long idSubcategoria) {
    //     return productRepository.findBySubcategory_Id(idSubcategoria).stream()
    //             .map(mapper::toDTO)
    //             .collect(Collectors.toSet());
    // }

    @Override
    public Set<ProductDTO> findAllByCategoriaNom(String nombreCategoria) {
        List<Product> productes = productRepository.findByCategoria_Nombre(nombreCategoria);
        return productes.stream()
                .map(botigaMapper::toDTO)
                .collect(Collectors.toSet());
    }
    
    

    @Override
    public boolean updatePrice(Long id, Long nouPreu) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(nouPreu);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}