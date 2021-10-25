package com.dddinjava.app.order.entity;


import com.dddinjava.app.order.exception.OrderException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 订单
 * @author zhaoxin
 */
@Table
public class Order implements Serializable {

  private static final long serialVersionUID = 2018294063450924495L;


  @Id
  private Long id;

  private String orderNo;

  private BigDecimal price;

  Set<OrderItem> items;

  public Long getId() {
    return id;
  }

  private void setId(Long id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  private void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public BigDecimal getPrice() {
    return price;
  }

  private void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Set<OrderItem> getItems() {
    return items;
  }

  private Order() {

  }

  public Order(String orderNo) {
    this.orderNo = orderNo;
    this.items = new HashSet(16);
    this.price = BigDecimal.ZERO;
  }

  public void addItem(OrderItem item) {
    this.items.add(item);
    this.price = this.price.add(item.getPrice());
  }

  public void removeItem(OrderItem orderItem) {
    if (this.items.isEmpty()) {
      throw new OrderException("订单条目为空");
    }
    this.items.remove(orderItem);
    this.price = this.price.subtract(orderItem.getPrice());

    if (this.items.isEmpty()) {
      throw new OrderException("订单条目为空");
    }
  }
}
