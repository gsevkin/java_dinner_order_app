package com.example.demo.dao;

import com.example.demo.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeOrderItemDao")
public class FakeOrderItemDataAccessService implements OrderItemDao {

    private static List<OrderItem> orderDB = new ArrayList<>();

    @Override
    public int insertOrderItem(UUID id, String customerName, String customerPhone, Date pickupTime, UUID menuItemID, String dishName, int amount, Date serveDate) {
        orderDB.add(new OrderItem(id, customerName, customerPhone, pickupTime, menuItemID, dishName, amount, serveDate));
        return 1;
    }

    @Override
    public int deleteOrderItemById(UUID id) {
        Optional<OrderItem> seletedOI = selectOrderItemById(id);
        if(seletedOI.isEmpty()){
            return 0;
        }
        orderDB.remove(seletedOI);
        return 1;
    }

    @Override
    public int updateOrderItemById(UUID id, OrderItem orderItem) {
        int ret = deleteOrderItemById(id);
        if (ret == 0){
            return 0;
        }
        return insertOrderItem(id, orderItem.getCustomerName(), orderItem.getCustomerPhone(), orderItem.getPickupTime(), orderItem.getMenuItemID(), orderItem.getDishName(), orderItem.getAmount(), orderItem.getServeDate());
    }

    @Override
    public List<OrderItem> selectAllOrderItems() {
        return orderDB;
    }

    @Override
    public Optional<OrderItem> selectOrderItemById(UUID id) {
        return orderDB.stream()
                .filter(orderItem -> orderItem.getId().equals(id))
                .findFirst();
    }
}
