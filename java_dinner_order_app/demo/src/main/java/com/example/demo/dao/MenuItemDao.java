package com.example.demo.dao;

import com.example.demo.model.MenuItem;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuItemDao {

    int insertMenuItem(UUID id, String name, String message, String price, String serveDate, String amountAvailable);
    int deleteMenuItemById(UUID id);
    int updateMenuItemById(UUID id, MenuItem person);
    List<MenuItem> selectAllMenuItems();
    Optional<MenuItem> selectMenuItemById(UUID id);

    default int insertMenuItem(String name, String message, String price, String serveDate, String amountAvailable){
        UUID id = UUID.randomUUID();
        return insertMenuItem(id, name, message, price, serveDate, amountAvailable);
    }
}
