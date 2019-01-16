package com.eshop.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {
    private Long id;
    private Integer inventoryNum;
    private Long productId;
}
