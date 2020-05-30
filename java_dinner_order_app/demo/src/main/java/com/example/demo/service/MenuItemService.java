package com.example.demo.service;

import com.example.demo.dao.MenuItemDao;
import com.example.demo.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuItemService {
    private final MenuItemDao menuItemDao;

    @Autowired
    public MenuItemService(@Qualifier("fakeMenuItemDao") MenuItemDao menuItemDao) {
        this.menuItemDao = menuItemDao;
    }

    public int deleteMenuItemById(UUID id){
        return menuItemDao.deleteMenuItemById(id);
    }

    public int updateMenuItemById(UUID id, MenuItem person){
        return menuItemDao.updateMenuItemById(id, person);
    }

    public List<MenuItem> selectAllMenuItems(){
        return menuItemDao.selectAllMenuItems();
    }

    public Optional<MenuItem> selectMenuItemById(UUID id){
        return menuItemDao.selectMenuItemById(id);
    }

    public int insertMenuItem(MenuItem menuItem) {
        return menuItemDao.insertMenuItem(menuItem.getName(), menuItem.getMessage(), menuItem.getPrice(), menuItem.getServingDate(), menuItem.getAmountAvailable());
    }
}
