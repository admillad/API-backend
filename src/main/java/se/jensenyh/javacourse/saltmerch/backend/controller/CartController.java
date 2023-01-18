package se.jensenyh.javacourse.saltmerch.backend.controller;//klar

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;


@CrossOrigin("http://localhost:3010")
@RequestMapping("/carts")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public Object getCartItems(@PathVariable("id") Integer id) {
        return cartService.getCartItems(id);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> addToOrRemoveFromCart(@PathVariable Integer id,
                                                        @RequestBody CartItem item,
                                                        @RequestParam @Nullable String action) {

        if (id == 1) {
            int res = cartService.updateCart(item, action);
            switch (res) {
                case 1:
                    return ResponseEntity.ok().build();
                case -2:
                    return ResponseEntity.badRequest().body("Cart is empty or we are out of stock");
                case -3:
                    return ResponseEntity.badRequest().body("please enter one of the following: add/remove");
                default:
                    ResponseEntity.internalServerError().body("Probably server error :)");
            }
        }
        return ResponseEntity.badRequest().body("The id is wrong, please try again.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> clearCart(@PathVariable Integer id,
                                            @RequestParam(required = false) Boolean buyout) {
        if (id == 1) {
            int res = cartService.deleteCart(buyout);
            switch (res) {
                case 1:
                case 2:
                    return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.badRequest().body("The id is wrong, please try again.");
    }
}

