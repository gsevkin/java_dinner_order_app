package com.example.demo.service;

import com.example.demo.dao.OrderItemDao;
import com.example.demo.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {
    OrderItemDao orderItemDao;

    @Autowired
    public OrderItemService(@Qualifier("fakeOrderItemDao") OrderItemDao orderItemDao){
        this.orderItemDao = orderItemDao;
    }

    public int insertOrderItem(String customerName, String customerPhone, Date pickupTime, UUID menuItemID, String dishName, int amount, Date serveDate) {
        return orderItemDao.insertOrderItem(customerName, customerPhone, pickupTime, menuItemID, dishName, amount, serveDate);
    }

    public int deleteOrderItemById(UUID id) {
        return orderItemDao.deleteOrderItemById(id);
    }

    public int updateOrderItemById(UUID id, OrderItem orderItem) {
        return orderItemDao.updateOrderItemById(id, orderItem);
    }

    public List<OrderItem> selectAllOrderItems() {
        return orderItemDao.selectAllOrderItems();
    }

    public Optional<OrderItem> selectOrderItemById(UUID id) {
        return orderItemDao.selectOrderItemById(id);
    }
}
