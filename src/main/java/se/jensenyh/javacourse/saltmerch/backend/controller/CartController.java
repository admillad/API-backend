package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@CrossOrigin("http://localhost:3010")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping ("/carts/{id}")
    public List<CartItem> getCartContent(){
        return cartService.getCartItems();

    }

    @PatchMapping("/carts/{id}?action=add")
    public void addProductToCart() {


    }

    @PatchMapping("/carts/{id}?action=remove")
    public void removeProductFromCart() {

    }

    @DeleteMapping("/carts/{id}")
    public void clearCart() {

    }

    @DeleteMapping("/carts/{id}?buyout=true")
    public void clearCartAndRestock() {
    }

}
