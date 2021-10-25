package com.dddinjava.app.order.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.dddinjava.app.order.entity.Order;
import com.dddinjava.app.order.entity.OrderItem;
import com.dddinjava.app.order.mapper.OrderItemMapper;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest
class OrderRepoTest {

  @NonNull
  private OrderRepo orderRepo;

  @NonNull
  private OrderItemMapper orderItemMapper;

  @Test
  void order() {

    Order order = new Order(UUID.randomUUID().toString().replace("-", ""));

    OrderItem iphone = new OrderItem(UUID.randomUUID().toString().replace("-", ""), "iphone 13", new BigDecimal("13000"));
    order.addItem(iphone);

    OrderItem airPods = new OrderItem(UUID.randomUUID().toString().replace("-", ""), "airPods", new BigDecimal("1000"));
    order.addItem(airPods);

    order = orderRepo.save(order);

    assertNotNull(order.getId());

  }

  @Test
  void findAll() {
    Iterable<Order> orders = orderRepo.findAll();
    assertNotNull(orders);
  }

  @Test
  void update() {
    String itemNo = "d8af1d621ea34ad4b0bbf772f6b75f8b";
    Optional<Order> orderOptional = orderRepo.findById(7L);

    OrderItem item = orderItemMapper.findByNo(itemNo);

    Order order = orderOptional.get();

    order.removeItem(item);

    orderRepo.save(order);


  }
}