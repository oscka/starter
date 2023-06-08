package com.hanex.starter.order.repository;

import com.hanex.starter.order.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> ,OrderRepositoryCustom {
}
