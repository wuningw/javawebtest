package com.wuning.service.impl;

import com.wuning.dao.BookDao;
import com.wuning.dao.OrderDao;
import com.wuning.dao.OrderItemDao;
import com.wuning.dao.impl.BookDaoImpl;
import com.wuning.dao.impl.OrderDaoImpl;
import com.wuning.dao.impl.OrderItemDaoImpl;
import com.wuning.pojo.*;
import com.wuning.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author wu
 * @date 2020-04-25 10:00
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
   private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.svaeOrder(order);
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.savaOrderItem(orderItem);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getStock()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
