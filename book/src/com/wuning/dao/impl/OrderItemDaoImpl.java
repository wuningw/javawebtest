package com.wuning.dao.impl;

import com.wuning.dao.OrderItemDao;
import com.wuning.pojo.OrderItem;

/**
 * @author wu
 * @date 2020-04-24 22:16
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int savaOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
