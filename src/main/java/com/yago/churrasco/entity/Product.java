package com.yago.churrasco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.Validate;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SKU", nullable = false)
    private Long SKU;

    @Column(nullable = false)
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String picture;

    @Column(nullable = false, columnDefinition = "Decimal(10,2)")
    private Float price;
    
    @Column
    private String currency;

    public Product() {
    }

    public Product(Long SKU, Integer code, String name, String description, String picture, Float price, String currency) {
        update(SKU, code, name, description, picture, price, currency);
    }

    public void update (Long SKU, Integer code, String name, String description,
                        String picture, Float price, String currency) {
        Validate.notNull(SKU, "SKU cannot be null.");
        Validate.notNull(code, "Code cannot be null.");
        Validate.notBlank(name, "Name cannot be blank.");
        Validate.notNull(price, "Price cannot be null.");
        Validate.isTrue(price > 0, "Price must be a positive number.");
        this.SKU = SKU;
        this.code = code;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    @JsonProperty("SKU")
    public Long getSKU() {
        return SKU;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public Float getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
