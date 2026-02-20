package edu.icet.service.impl;

import edu.icet.model.dto.OrderDto;
import edu.icet.repository.OrderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private  final OrderRepository orderRepository;

    @Override
    public boolean addOrder(OrderDto orderDto) {
        return orderRepository.addOrder(orderDto);
    }

    @Override
    public boolean updateOrder(OrderDto orderDto) {
        return orderRepository.updateOrder(orderDto);
    }

    @Override
    public boolean deleteOrder(String id) {
        return orderRepository.deleteOrder(id);
    }

    @Override
    public OrderDto searchOrderById(String id) {
        return orderRepository.searchOrderById(id);
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.getAll();
    }
}
