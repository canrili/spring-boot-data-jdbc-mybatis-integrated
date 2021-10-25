package com.dddinjava.app.order.repo;

import com.dddinjava.app.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhaoxin
 */
public interface OrderRepo extends CrudRepository<Order, Long> {

}
