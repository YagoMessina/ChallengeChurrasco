package com.yago.churrasco.controller;

import com.yago.churrasco.dto.ProductDTO;
import com.yago.churrasco.entity.Product;
import com.yago.churrasco.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody @Valid ProductDTO productDTO) {
        Product product = productService.save(productDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping()
    private ResponseEntity<?> read(@RequestParam Map<String, String> filters) {
        return ResponseEntity.ok(productService.find(filters));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> readById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.update(productDTO));
    }
}
