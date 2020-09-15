package com.wuning.dao.impl;

import com.wuning.dao.OrderDao;
import com.wuning.pojo.Order;

/**
 * @author wu
 * @date 2020-04-24 22:04
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int svaeOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStauts(),order.getUserId());

    }
}
