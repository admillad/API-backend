package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.ColorVariant;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;


@CrossOrigin("http://localhost:3010")
@RequestMapping("/products")
@RestController

public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public Object getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/hats")
    public Object getHats() {
        return productService.getProductByCategory("hats");
    }
    @GetMapping("/jackets")
    public Object getJackets() {
        return productService.getProductByCategory("jackets");
    }
    @GetMapping("/tshirts")
    public Object getTshirts() {
        return productService.getProductByCategory("tshirts");
    }
    @GetMapping("/bags")
    public Object getBags() {
        return productService.getProductByCategory("bags");
    }
    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @GetMapping("/hats/{id}")
    public Object getHatsById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @GetMapping("/jackets/{id}")
    public Object getJacketsByID(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @GetMapping("/tshirts/{id}")
    public Object getTshirtsById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
    @GetMapping("/bags/{id}")
    public Object getBagsById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Object putProduct(@PathVariable Integer id, @RequestBody Product product) {
        int res = productService.updateProduct(id, product);
        return switch (res) {
            case 1 -> ResponseEntity.ok().build();
            case -9 -> ResponseEntity.badRequest().body("No product with that id");
            default -> ResponseEntity.internalServerError().body("sorry, server error");
        };
    }
    @PutMapping("/{id}/variants/stock")
    public Object putVariants(@PathVariable int id,
                              @RequestParam String size,
                              String color,
                              int quantity) {
        return productService.restockSpecificSizeOfVariant(id, size, color, quantity);
    }

}


