package com.eshop.product.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecification {
    private Long id;
    private String name;
    private String value;
    private Long productId;
}
