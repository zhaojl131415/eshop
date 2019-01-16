package com.eshop.product.mapper;

import com.eshop.product.entity.Brand;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BrandMapper {

    @Insert("insert into brand(name, description) values(#{name}, #{description})")
    void insert(Brand brand);

    @Update("update brand set name = #{name} , description = #{description} where id = #{id}")
    void update(Brand brand);

    @Delete("delete from brand where id = #{id}")
    void delete(Long id);

    @Select("select * from brand where id = #{id}")
    Brand findById(Long id);
}
