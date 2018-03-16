package com.lizl.eshop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lizl.eshop.mapper.ProductInventoryMapper;
import com.lizl.eshop.model.ProductInventory;
import com.lizl.eshop.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Autowired
    private ProductInventoryMapper productInventoryMapper;
    @Autowired
    private JedisPool jedisPool;


    public void add(ProductInventory productInventory) {
        productInventoryMapper.add(productInventory);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_inventory_" +productInventory.getId(), JSONObject.toJSONString(productInventory));
    }

    public void update(ProductInventory productInventory) {
        productInventoryMapper.update(productInventory);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_inventory_" +productInventory.getId(), JSONObject.toJSONString(productInventory));
    }

    public void delete(Integer id) {
        ProductInventory productInventory = findById(id);
        productInventoryMapper.delete(id);
        Jedis jedis = jedisPool.getResource();
        jedis.del("product_inventory_" + productInventory.getId());
    }

    public ProductInventory findById(Integer id) {
        return productInventoryMapper.findById(id);
    }
}
