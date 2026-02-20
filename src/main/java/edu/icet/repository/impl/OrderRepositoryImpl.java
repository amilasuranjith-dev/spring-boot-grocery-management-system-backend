package edu.icet.repository.impl;

import edu.icet.model.dto.OrderDto;
import edu.icet.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addOrder(OrderDto orderDto) {
        String sql  = "INSERT INTO orders VALUES (?,?,?)";
        return jdbcTemplate.update(sql,
                orderDto.getId(),
                orderDto.getDate(),
                orderDto.getCustId()
                )>0;
    }

    @Override
    public boolean updateOrder(OrderDto orderDto) {
        String sql = "UPDATE orders SET OrderDate=?, CustID=? WHERE OrderID=?";
        return jdbcTemplate.update(sql,
                orderDto.getDate(),
                orderDto.getCustId(),
                orderDto.getId()
        )>0;
    }

    @Override
    public boolean deleteOrder(String id) {
        return jdbcTemplate.update("DELETE FROM orders WHERE OrderID=?", id)>0;
    }

    @Override
    public OrderDto searchOrderById(String id) {
        String sql = "SELECT * FROM orders WHERE OrderID=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(rs.getString(1));
            orderDto.setDate(rs.getDate(2));
            orderDto.setCustId(rs.getString(3));
            return orderDto;
        }, id);
    }

    @Override
    public List<OrderDto> getAll() {
        String sql = "SELECT * FROM orders";
        List<OrderDto> orderDtoList =  jdbcTemplate.query(sql, (rs, rowNum) -> {
           OrderDto orderDto = new OrderDto();
           orderDto.setId(rs.getString(1));
           orderDto.setDate(rs.getDate(2));
           orderDto.setCustId(rs.getString(3));
           return orderDto;
        });
        return orderDtoList;
    }
}
