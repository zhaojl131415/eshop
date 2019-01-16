package com.eshop.inventory.mapper;

import com.eshop.inventory.entity.ProductInventory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductInventoryMapper {

    @Insert("insert into product_inventory(inventory_num, product_id) values(#{inventoryNum}, #{productId})")
    void insert(ProductInventory productInventory);

    @Update("update product_inventory set inventory_num = #{inventoryNum}, product_id = #{productId} where id = #{id}")
    void update(ProductInventory productInventory);

    @Delete("delete from product_inventory where id = #{id}")
    void delete(Long id);

    @Select("select * from product_inventory where id = #{id}")
    @Results({
            @Result(column = "inventory_num", property = "inventoryNum")
    })
    ProductInventory findById(Long id);
}
