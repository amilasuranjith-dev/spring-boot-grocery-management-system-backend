package edu.icet.service;

import edu.icet.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    boolean addOrder(OrderDto orderDto);
    boolean updateOrder(OrderDto orderDto);
    boolean deleteOrder(String id);
    OrderDto searchOrderById(String id);
    List<OrderDto> getAll();
}
