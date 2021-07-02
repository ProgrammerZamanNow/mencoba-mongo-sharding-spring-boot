package com.blibli.mongosharding.repository;

import com.blibli.mongosharding.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

  List<Order> findAllByUserId(String userId, Sort sort);

}
