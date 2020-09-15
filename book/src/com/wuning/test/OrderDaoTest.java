package com.wuning.test;

import com.wuning.dao.OrderDao;
import com.wuning.dao.impl.OrderDaoImpl;
import com.wuning.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    @Test
    public void svaeOrder (){
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.svaeOrder(new Order("12334455",new Date(),new BigDecimal(100),1,1));
    }

}