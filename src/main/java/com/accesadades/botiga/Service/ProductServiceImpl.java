package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Mapper.ProductMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
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
    }
}
