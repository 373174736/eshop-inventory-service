package com.lizl.eshop.controller;

import com.lizl.eshop.model.ProductInventory;
import com.lizl.eshop.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/23.
 */
@RequestMapping("/product-inventory")
@RestController
public class ProductInventoryController {

    @Autowired
    ProductInventoryService productInventoryService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductInventory productInventory){
        productInventoryService.add(productInventory);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductInventory productInventory){
        productInventoryService.update(productInventory);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        try {
            productInventoryService.delete(id);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("/findById")
    @ResponseBody
    public ProductInventory findById(Integer id){
        try {
            return  productInventoryService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductInventory();
    }

    @RequestMapping("/findByProductId")
    @ResponseBody
    public ProductInventory findByProductId(Integer productId){
        try {
            return  productInventoryService.findByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductInventory();
    }
}
