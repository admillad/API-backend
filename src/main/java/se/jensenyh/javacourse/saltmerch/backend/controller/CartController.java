package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

@CrossOrigin("http://localhost:3010")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

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
