package com.paperpigeon.service;

import com.paperpigeon.dto.OrderDTO;
import com.paperpigeon.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Huzdu on 3/16/2017.
 */
@Service
public interface OrderService {
    OrderDTO create(OrderDTO dto);

    OrderDTO delete(String id);

    List<OrderDTO> findAll();

    OrderDTO findById(String id);

    OrderDTO update(UserDTO todo);

}
