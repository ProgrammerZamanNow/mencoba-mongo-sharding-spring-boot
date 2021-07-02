package com.blibli.mongosharding.controller;

import com.blibli.mongosharding.entity.Order;
import com.blibli.mongosharding.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {

  private final OrderRepository orderRepository;

  @PostMapping(
      value = "/orders",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Order create(@RequestBody Order order) {
    return orderRepository.save(order);
  }

  @GetMapping(
      value = "/orders",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<Order> list() {
    return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "amount"));
  }

  @GetMapping(
      value = "/orders/{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<Order> listByUserId(@PathVariable("userId") String userId) {
    return orderRepository.findAllByUserId(userId, Sort.by(Sort.Direction.DESC, "amount"));
  }

}
