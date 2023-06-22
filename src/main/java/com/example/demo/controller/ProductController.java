package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list() {
        return service.listAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/editProduct")
    public void editProduct(@RequestBody Product product){
        service.editProduct(product);
    }

    @GetMapping("/deleteProduct/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.delete(id);
    }
}
