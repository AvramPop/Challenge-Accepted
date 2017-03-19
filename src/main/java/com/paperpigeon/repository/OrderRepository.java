package com.paperpigeon.repository;

import com.paperpigeon.model.Order;
import com.paperpigeon.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Huzdu on 3/16/2017.
 */
public interface OrderRepository extends Repository<Order,String>  {
    void delete(User deleted);

    List<Order> findAll();

    Optional<Order> findOne(String id);

    Order save(Order saved);

}
