package com.example.demo.dao;

import com.example.demo.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeMenuItemDao")
public class FakeMenuItemDataAccessService implements MenuItemDao {

    private static List<MenuItem> menu = new ArrayList<>();

    @Override
    public int insertMenuItem(UUID id, String name, String message, String price, String serveDate, String amountAvailable) {
        MenuItem menuItem = new MenuItem(id, name, message, price, serveDate, amountAvailable);
        menu.add(menuItem);
        return 1;
    }

    @Override
    public int deleteMenuItemById(UUID id) {
        Optional<MenuItem> menuItem = selectMenuItemById(id);
        if(menuItem.isEmpty()){
            return 0;
        }

        menu.remove(menuItem);
        return 1;
    }

    @Override
    public int updateMenuItemById(UUID id, MenuItem menuItem) {
        if (deleteMenuItemById(id) == 0){
            return 0;
        }

        return insertMenuItem(id, menuItem.getName(), menuItem.getMessage(), menuItem.getPrice(), menuItem.getServingDate(), menuItem.getAmountAvailable());
    }

    @Override
    public List<MenuItem> selectAllMenuItems() {
        return menu;
    }

    @Override
    public Optional<MenuItem> selectMenuItemById(UUID id) {
        return menu.stream()
                .filter(menuItem -> menuItem.getId().equals(id))
                .findFirst();
    }
}
