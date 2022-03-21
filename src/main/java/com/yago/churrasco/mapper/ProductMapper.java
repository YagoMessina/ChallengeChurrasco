package com.yago.churrasco.mapper;

import com.yago.churrasco.dto.ProductDTO;
import com.yago.churrasco.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        return new Product(productDTO.getSKU(), productDTO.getCode(), productDTO.getName(),
                productDTO.getDescription(), productDTO.getPicture(), productDTO.getPrice(),
                productDTO.getCurrency());
    }
}
