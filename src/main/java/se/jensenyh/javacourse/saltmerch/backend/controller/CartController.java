package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

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

    @PatchMapping({"/{id}?action=add"})
    public ResponseEntity addCartItem(@PathVariable("id") Integer id,
                                      @RequestBody CartItem item,
                                      @RequestParam(value = "action") String add) {
        int res = cartService.addingCartItem(id, item, add);
        switch (res) {
            case 1:
                return ResponseEntity.ok().build();
            case -2:
                return ResponseEntity.badRequest().body("No product with that id exist");
            case -3:
                return ResponseEntity.badRequest().body("The item is not in stock");
            default:ResponseEntity.internalServerError().body("Server error");
        }


    }

    @PatchMapping({"/{id}?action=remove"})
    public ResponseEntity removeCartItem(@PathVariable("id") Integer id,
                                                 @RequestBody CartItem cartItem,
                                                 @RequestParam String action) {

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> clearCart(@PathVariable("id") Integer id) {
        if (cartService.clearCartAndUpdateIfBoolTrue() >= 0)
            return ResponseEntity.ok().build();
        return ResponseEntity.internalServerError().build();

    }

    @DeleteMapping("/{id}?buyout=true")
    public ResponseEntity<Object> clearCart(@PathVariable("id") Integer id, boolean buyout) {
        if (cartService.clearCartAndUpdateIfBoolTrue() >= 0)
            return ResponseEntity.ok().build();
        return ResponseEntity.internalServerError().build();

    }
}
