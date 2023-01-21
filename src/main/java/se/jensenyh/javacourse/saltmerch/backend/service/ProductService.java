package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Product createProduct(int id, Product product, String category) {
        return pr.insertProductAndProps(product, category);
    }

    public int updateProduct(int id, Product product) {
        return pr.updateProductMeta(id, product);
    }

}
