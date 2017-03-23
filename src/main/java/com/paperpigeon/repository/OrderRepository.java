package com.paperpigeon.repository;


import com.paperpigeon.model.Order;
import com.paperpigeon.model.Order;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Here are the operations linked to the repo,
 * they are probably the same for every object
 */

public interface OrderRepository extends Repository<Order, String> {

    void delete(Order deleted);

    List<Order> findAll();

    Optional<Order> findOne(String id);

    Order save(Order saved);
}
