package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    public static Map<Integer, Product> productMap= new HashMap<>();

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public Product findById(int id) {
        return productMap.get(id);
    }

    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    public void delete(int id) {
        productMap.remove(id);
    }
}
