package com.example.demo.api;

import com.example.demo.model.MenuItem;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/orderitem")
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public void addMenuItem(@RequestBody OrderItem orderItem){
        orderItemService.insertOrderItem(orderItem.getCustomerName(), orderItem.getCustomerPhone(), orderItem.getPickupTime(), orderItem.getMenuItemID(), orderItem.getDishName(), orderItem.getAmount(), orderItem.getServeDate());
    }

    @GetMapping
    public List<OrderItem> getAllMenuItems(){
        return orderItemService.selectAllOrderItems();
    }

    @GetMapping(path = "{id}")
    public OrderItem getMenuItemById(@PathVariable("id") UUID id){
        return orderItemService.selectOrderItemById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMenuItemById(@PathVariable("id") UUID id){
        orderItemService.deleteOrderItemById(id);
    }

    @PutMapping(path = "{id}")
    public void updateMenuItem(@PathVariable("id") UUID id, @RequestBody OrderItem orderItem){
        orderItemService.updateOrderItemById(id, orderItem);
    }

}
