package com.wuning.test;

import com.wuning.dao.OrderItemDao;
import com.wuning.dao.impl.OrderItemDaoImpl;
import com.wuning.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    @Test
    public void savaOrderItem(){
        OrderItemDao orderItemDao= new OrderItemDaoImpl();
        orderItemDao.savaOrderItem(new OrderItem(null,"java从入门到放弃",1,new BigDecimal(100),new BigDecimal(100),"12334455"));
    }

}