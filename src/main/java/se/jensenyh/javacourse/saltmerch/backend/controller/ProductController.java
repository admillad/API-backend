package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

@CrossOrigin("http://localhost:3010")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public void getAllProducts(@RequestBody Product product) {
        productService.GetAllProducts();

    }

    @GetMapping("products/{categoryId}")
    public void getAllProductsInCategory() {

    }

    @GetMapping("/products/{id}")
    public void getProduct() {

    }

    @PostMapping("/products/{id}/{categoryId}")
    public void addNewProduct() {

    }

    @PutMapping("/products/{id}")
    public void UpdateProduct() {

    }

    @PostMapping("/products/{id}/variants")
    public void newVariant() {

    }

    @PutMapping("/products/{id}/variants/stock?size={size}&color={green}&quantity={quantity}")
    public void restockSize() {

    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct() {

    }

    @DeleteMapping("/products/{productId}/variants/{variantId}")
    public void deleteVarietyProducts() {

    }
}

