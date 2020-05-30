package com.example.demo.api;

import com.example.demo.model.MenuItem;
import com.example.demo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/menuitem")
@RestController
public class MenuItemController {
    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public void addMenuItem(@RequestBody MenuItem menuItem){
        menuItemService.insertMenuItem(menuItem);
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems(){
        return menuItemService.selectAllMenuItems();
    }

    @GetMapping(path = "{id}")
    public MenuItem getMenuItemById(@PathVariable("id") UUID id){
        return menuItemService.selectMenuItemById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMenuItemById(@PathVariable("id") UUID id){
        menuItemService.deleteMenuItemById(id);
    }

    @PutMapping(path = "{id}")
    public void updateMenuItem(@PathVariable("id") UUID id, @RequestBody MenuItem menuItem){
        menuItemService.updateMenuItemById(id, menuItem);
    }
}
