package com.wuning.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wu
 * @date 2020-04-24 21:47
 */
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    //0表示未发货，1表示发货，2表示签收
    private Integer stauts =0;
    private  Integer userId;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer stauts, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.stauts = stauts;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", stauts=" + stauts +
                ", userId=" + userId +
                '}';
    }
}
