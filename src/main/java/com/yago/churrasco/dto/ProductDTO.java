package com.yago.churrasco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductDTO {

    private Integer id;

    @NotNull(message = "SKU cannot be null.")
    @JsonProperty("SKU")
    private Long SKU;

    @NotNull(message = "Code cannot be null.")
    private Integer code;

    @NotNull(message = "Name cannot be null.")
    @NotBlank(message = "Name cannot be blank.")
    private String name;

    private String description;

    private String picture;

    @NotNull(message = "Price cannot be null.")
    @Positive(message = "Price must be a positive number.")
    private Float price;

    private String currency;
}
