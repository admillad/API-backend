package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Object getAllHats() {
        return productService.getProductByCategory("hats");
    }

    @GetMapping("/jackets")
    public Object getAllJackets() {
        return productService.getProductByCategory("jackets");
    }

    @GetMapping("/tshirts")
    public Object getAllTshirts() {
        return productService.getProductByCategory("tshirts");
    }

    @GetMapping("/bags")
    public Object getAllBags() {
        return productService.getProductByCategory("bags");
    }

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Object putProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        int res = productService.updateProduct(id, product);
        return switch (res) {
            case 1 -> ResponseEntity.ok().build();
            case -9 -> ResponseEntity.badRequest().body("No product with that id");
            default -> ResponseEntity.internalServerError().body("sorry, server error");
        };
    }
}

