package com.example.demo.dao;

import com.example.demo.model.MenuItem;
import com.example.demo.model.OrderItem;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemDao {
    int insertOrderItem(UUID id, String customerName, String customerPhone, Date pickupTime, UUID menuItemID, String dishName, int amount, Date serveDate);
    int deleteOrderItemById(UUID id);
    int updateOrderItemById(UUID id, OrderItem orderItem);
    List<OrderItem> selectAllOrderItems();
    Optional<OrderItem> selectOrderItemById(UUID id);

    default int insertOrderItem(String customerName, String customerPhone, Date pickupTime, UUID menuItemID, String dishName, int amount, Date serveDate){
        UUID id = UUID.randomUUID();
        return insertOrderItem(id, customerName, customerPhone, pickupTime, menuItemID, dishName, amount, serveDate);
    }
}
