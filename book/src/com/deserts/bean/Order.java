package com.deserts.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author deserts
 * @Date 2020/9/27 15:07
 */
public class Order {
    private String orderId;
    private Date creatTime;
    private BigDecimal price;
    /**
     * 0表示未发货，1表示已发货，2表示已签收
     */
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date creatTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.creatTime = creatTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
