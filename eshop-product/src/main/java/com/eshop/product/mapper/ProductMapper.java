package com.eshop.product.mapper;

import com.eshop.product.entity.Product;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {

    @Insert("insert into product(name, category_id, brand_id) values(#{name}, #{categoryId}, #{brandId})")
    void insert(Product product);

    @Update("update product set name = #{name}, category_id = #{categoryId}, brand_id = #{brandId} where id = #{id}")
    void update(Product product);

    @Delete("delete from product where id = #{id}")
    void delete(Long id);

    @Select("select * from product where id = #{id}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "brand_id", property = "brandId")
    })
    Product findById(Long id);
}
