package service;

import model.Product;

import java.util.*;

public class ProductService {
    public static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "John", "100", "Hanoi"));
        productMap.put(2, new Product(2, "Bill", "200", "Danang"));
        productMap.put(3, new Product(3, "Alex", "200", "Saigon"));
    }

    public List<Product> findAll() {
        Collection<Product> c = productMap.values();
        return new ArrayList<>(c);
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
