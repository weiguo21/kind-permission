package com.kind.common.task.dto;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class ShoppingDto {

    public ShoppingDto() {
    }

    public ShoppingDto(String type, Integer price, Integer quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 单价
     */
    private Integer price;
    /**
     * 数量
     */
    private Integer quantity;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
