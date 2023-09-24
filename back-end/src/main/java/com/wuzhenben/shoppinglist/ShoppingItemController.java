package com.wuzhenben.shoppinglist;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shopping-items")
public class ShoppingItemController {

    private final ShoppingItemRepository shoppingItemRepository;

    public ShoppingItemController(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    @PostMapping
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        return this.shoppingItemRepository.save(shoppingItem);
    }
}
