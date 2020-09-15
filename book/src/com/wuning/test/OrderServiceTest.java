package com.wuning.test;

import com.wuning.pojo.Cart;
import com.wuning.pojo.CartItem;
import com.wuning.pojo.OrderItem;
import com.wuning.service.OrderService;
import com.wuning.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"入门到入土",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"入门到入土",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"无线人生",1,new BigDecimal(900),new BigDecimal(900)));
        OrderService orderService=new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }
}