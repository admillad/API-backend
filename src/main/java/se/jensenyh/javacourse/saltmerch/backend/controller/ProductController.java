package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3010")
@RestController
public class ProductController {
    @GetMapping("/products")
    public void getAllProducts() {

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
    //@PostMapping ("/products/{id}/variant")
    //public void newVariant() {}

    @PostMapping("/products/{id}/variants")
    public void newVariant() {

    }

    @PutMapping("/products/{id}/variants/stock?size={size}&color={green}&quantity={quan tity}")
    public void restockSize() {

    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct() {

    }

    @DeleteMapping("/products/{productId}/variants/{variantId}")
    public void deleteVarietyProducts() {

    }
}

