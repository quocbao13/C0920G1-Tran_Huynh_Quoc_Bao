package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findOne(Long id);
}
