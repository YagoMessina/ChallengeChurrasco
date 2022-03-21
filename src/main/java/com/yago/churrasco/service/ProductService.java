package com.yago.churrasco.service;

import com.yago.churrasco.dto.ProductDTO;
import com.yago.churrasco.entity.Product;
import com.yago.churrasco.error.ApiException;
import com.yago.churrasco.mapper.ProductMapper;
import com.yago.churrasco.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        return productRepository.save(product);
    }

    public List<Product> find(Map<String, String> filters) {
        return productRepository.findByFilter(filters);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product update(ProductDTO productDTO) {
        Product product = findById(productDTO.getId());
        product.update(productDTO.getSKU(), productDTO.getCode(), productDTO.getName(), productDTO.getDescription(),
                productDTO.getPicture(), productDTO.getPrice(), productDTO.getCurrency());
        return product;
    }
}
