package com.blibli.mongosharding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;
import org.springframework.data.mongodb.core.mapping.ShardingStrategy;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Sharded(shardKey = "userId", shardingStrategy = ShardingStrategy.HASH)
@Document(collection = "orders")
public class Order {

  @Id
  private String id;

  private Long amount;

  private String userId;

}
