package bai_tap.service;

import bai_tap.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
//        productList.add(new Product(1, "Iphone", 2000, "h1.jpg", 10));
//        productList.add(new Product(2, "SamSung", 1000, "h2.jpg", 20));
//        productList.add(new Product(3, "Oppo", 500, "h3.jpg", 16));
//        productList.add(new Product(4, "Nokia", 700, "h4.jpg", 5));
//        productList.add(new Product(5, "Seomi", 1300, "h5.jpg", 8));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product Product) {

    }

    @Override
    public void remove(int id) {

    }
}
