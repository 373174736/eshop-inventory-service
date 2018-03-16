package com.lizl.eshop.model;

/**
 * Created by lizhaoliang on 18/2/23.
 */
public class ProductInventory {

    private Integer id;
    private Double value;
    private Integer productId;

    public ProductInventory(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
