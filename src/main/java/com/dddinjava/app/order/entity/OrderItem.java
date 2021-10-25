package com.dddinjava.app.order.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 订单条目
 * @author zhaoxin
 */
@Table
public class OrderItem implements Serializable {

  private static final long serialVersionUID = -4763675821135713747L;

  @Id
  private Long id;

  private String no;

  private String name;

  private BigDecimal price;

  public Long getId() {
    return id;
  }

  private void setId(Long id) {
    this.id = id;
  }

  public String getNo() {
    return no;
  }

  private void setNo(String no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(no, orderItem.no);
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  private OrderItem() {
  }

  public OrderItem(String no, String name, BigDecimal price) {
    this.no = no;
    this.name = name;
    this.price = price;
  }
}
