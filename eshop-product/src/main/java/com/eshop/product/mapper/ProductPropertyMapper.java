package com.eshop.product.mapper;

import com.eshop.product.entity.ProductProperty;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductPropertyMapper {

    @Insert("insert into product_property(name, value, product_id) values(#{name}, #{value}, #{productId})")
    void insert(ProductProperty productProperty);

    @Update("update product_property set name = #{name}, value = #{value}, product_id = #{productId} where id = #{id}")
    void update(ProductProperty productProperty);

    @Delete("delete from product_property where id = #{id}")
    void delete(Long id);

    @Select("select * from product_property where id = #{id}")
    @Results({
            @Result(column = "product_id", property = "productId")
    })
    ProductProperty findById(Long id);
}
