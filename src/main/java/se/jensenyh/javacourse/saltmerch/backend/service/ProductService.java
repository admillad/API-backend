package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.ColorVariant;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository pr;

    public List<Product> getProducts() {
        return pr.selectAll();
    }

    public List<Product> getProductByCategory(String category) {
        return pr.selectAllOfCategory(category);
    }

    public Object getProductById(int id) {
        return pr.getEntireProduct(id);
    }

    public Product createProduct(Product prod, String category) {
        return pr.insertProductAndProps(prod, category);
    }

    public int updateProduct(int id, Product product) {
        return pr.updateProductMeta(id, product);
    }


    public Object createVariant(int id, ColorVariant colorVariant) {
        return pr.addVariant(id, colorVariant);
    }

    public Object restockSpecificSizeOfVariant(int id, String size, String color, int quantity) {
        return pr.restockSize(id, size, color, quantity);
    }

    public Object deleteProduct(int id) {
       return pr.deleteProduct(id);
    }

    public Object deleteVariant(int pid, String color) {
       return pr.deleteVariant(pid, color);
    }


}
