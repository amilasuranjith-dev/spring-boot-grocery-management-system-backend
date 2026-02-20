package edu.icet.repository;

import edu.icet.model.dto.OrderDto;

import java.util.List;

public interface OrderRepository {
    boolean addOrder(OrderDto orderDto);
    boolean updateOrder(OrderDto orderDto);
    boolean deleteOrder(String id);
    OrderDto searchOrderById(String id);
    List<OrderDto> getAll();
}
