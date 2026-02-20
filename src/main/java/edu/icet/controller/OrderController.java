package edu.icet.controller;

import edu.icet.model.dto.OrderDto;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public boolean addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/update")
    public boolean updateOrder(@RequestBody OrderDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public boolean deleteOrder(@PathVariable String id){
        return orderService.deleteOrder(id);
    }

    @GetMapping("/search-by-id/{id}")
    public OrderDto searchById(@PathVariable String id){
        return orderService.searchOrderById(id);
    }

    @GetMapping("/getAll")
    public List<OrderDto> getALL(){
        return orderService.getAll();
    }


}
