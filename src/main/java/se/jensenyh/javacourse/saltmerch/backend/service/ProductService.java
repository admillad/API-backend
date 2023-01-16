package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

public class ProductService {
    @Autowired
    ProductRepository pr;

    public List<Product> GetAllProducts() {
        if (pr.selectAll() == null || pr.selectAll().isEmpty()) {
            throw new IllegalStateException("no products for the moment");

        } else
            return pr.selectAll();
    }

    public List<Product>GetProductByCategory(int id){
        return pr.selectAllOfCategory()
    }
}
