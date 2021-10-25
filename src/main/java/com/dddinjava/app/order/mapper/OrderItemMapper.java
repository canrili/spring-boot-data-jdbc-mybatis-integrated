package com.dddinjava.app.order.mapper;

import com.dddinjava.app.order.entity.OrderItem;

/**
 * @author zhaoxin
 */
public interface OrderItemMapper {

  OrderItem findByNo(String no);
}
