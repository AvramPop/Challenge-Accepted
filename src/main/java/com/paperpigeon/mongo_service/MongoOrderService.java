package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.OrderDTO;
import com.paperpigeon.exception.CardNotFoundException;
import com.paperpigeon.exception.UserNotFoundException;
import com.paperpigeon.model.Card;
import com.paperpigeon.repository.CardRepository;
import com.paperpigeon.repository.OrderRepository;
import com.paperpigeon.repository.UserRepository;
import com.paperpigeon.service.OrderService;
import com.paperpigeon.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * This is the place where we implement the methods from the controller(here, OrderController)
 * the way they behave and connect to the DB
 * <p>!NEVER forget to save your changes in the DB (obj = repository.save(obj))!!</p>
 */

@Service
public final class MongoOrderService implements OrderService {

    private final OrderRepository repository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Autowired
    public MongoOrderService(OrderRepository repository, CardRepository cardRepository,
                             UserRepository userRepository) {
        this.repository = repository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDTO create(OrderDTO order) throws CardNotFoundException, UserNotFoundException {
        if(cardRepository.findOne(order.getCardId()).isPresent()){
            if(userRepository.findOne(order.getOwnerId()).isPresent()){
                Order persisted = Order.getBuilder()
                        .address(order.getAddress())
                        .cardId(order.getCardId())
                        .dateOrder()
                        .ownerId(order.getOwnerId())
                        .build();
                persisted = repository.save(persisted);
                return convertToDTO(persisted);
            } else {
                throw new UserNotFoundException("User with id " + order.getOwnerId() + " could not be found!");
            }
        } else {
            throw new CardNotFoundException("Card with id " + order.getCardId() + " could not be found!");
        }
    }

    @Override
    public OrderDTO delete(String id) {
        Order deleted = findOrderById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orderEntries = repository.findAll();
        return convertToDTOs(orderEntries);
    }

    private List<OrderDTO> convertToDTOs(List<Order> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public OrderDTO findById(String id) {
        Order found = findOrderById(id);
        return convertToDTO(found);
    }

    @Override
    public OrderDTO update(OrderDTO order) {
        Order updated = findOrderById(order.getId());
        String address = order.getAddress() == null ? updated.getAddress() : order.getAddress();
        String cardId = order.getCardId() == null ? updated.getCardId() : order.getCardId();
        String ownerId = order.getOwnerId() == null ? updated.getOwnerId() : order.getOwnerId();
        updated.update(address, cardId, ownerId);
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Order findOrderById(String id) {
        Optional<Order> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));

    }

    private OrderDTO convertToDTO(Order model) {
        OrderDTO dto = new OrderDTO();

        dto.setId(model.getId());
        dto.setAddress(model.getAddress());
        dto.setCardId(model.getCardId());
        dto.setOrderDate(model.getOrderDate());
        dto.setOwnerId(model.getOwnerId());

        return dto;
    }
}