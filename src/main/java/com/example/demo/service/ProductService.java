package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> listAllProducts() {
        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void editProduct(Product product){
        Product currentProduct = repository.findById(product.getId()).get();
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        repository.save(currentProduct);
    }

    public Product get(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
