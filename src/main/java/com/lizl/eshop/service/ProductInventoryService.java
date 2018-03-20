package com.lizl.eshop.service;

import com.lizl.eshop.model.ProductInventory;

/**
 * Created by lizhaoliang on 18/2/23.
 */
public interface ProductInventoryService {

    public void add(ProductInventory productInventory);

    public void update(ProductInventory productInventory);

    public void delete(Integer id);

    public ProductInventory findById(Integer id);

    public ProductInventory findByProductId(Integer productId);
}
