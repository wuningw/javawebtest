package com.wuning.service;

import com.wuning.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);

}
