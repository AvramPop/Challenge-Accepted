package com.paperpigeon.service;

import com.paperpigeon.dto.OrderDTO;
import com.paperpigeon.exception.CardNotFoundException;
import com.paperpigeon.exception.UserNotFoundException;

import java.util.List;

/**
 * Created by dani on 3/22/17.
 package com.paperpigeon.service;


 import com.paperpigeon.dto.OrderDTO;

 import java.util.List;

 /**
 * Here are the methods of Order that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */

public interface OrderService {

    OrderDTO create(OrderDTO order) throws CardNotFoundException, UserNotFoundException;

    OrderDTO delete(String id);

    List<OrderDTO> findAll();

    OrderDTO findById(String id);

    OrderDTO update(OrderDTO order);
}