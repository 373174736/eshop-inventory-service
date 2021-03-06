package com.lizl.eshop.mapper;

import com.lizl.eshop.model.ProductInventory;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@Mapper
public interface ProductInventoryMapper {

    @Insert("INSERT INTO product_inventory(value,product_id) VALUES(#{value},#{productId})")
    public void add(ProductInventory productInventory);
    @Update("UPDATE product_inventory SET value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductInventory productInventory);
    @Delete("DELETE FROM product_inventory WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product_inventory WHERE id=#{id}")
    public ProductInventory findById(Integer id);
    @Select("SELECT * FROM product_inventory WHERE product_id=#{product_id} limit 1")
    public ProductInventory findByProductId(Integer id);
}
