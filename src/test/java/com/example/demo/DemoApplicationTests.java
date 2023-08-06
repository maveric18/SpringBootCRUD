package com.example.demo;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Order(1)
    public void testCreate() {
        Product product = new Product();
        product.setName("NothingPhone1");
        product.setPrice(350);
//		product.setId(5);
        productRepository.save(product);
        assertNotNull(productRepository.findById(1).get());
    }

    @Test
    @Order(2)
    public void testRead() {
        List<Product> list = productRepository.findAll();
        assertThat(list, hasSize(greaterThan(0)));
//		list.forEach(s-> System.out.println(s.getName() + ", " + s.getPrice()));
    }

    @Test
    @Order(3)
    public void testSingleProduct() {
        Product product = productRepository.findById(1).get();
        assertEquals(product.getPrice().equals(350),true);
    }

    @Test
    @Order(4)
    public void updateProduct() {
        Product product = productRepository.findById(1).get();
        product.setName("Motorola");
        productRepository.saveAndFlush(product);
        assertNotEquals(Optional.of("Samsung"), productRepository.findById(1).get().getName());
    }

    @Test
    @Order(5)
    public void deleteProductTest() {
        productRepository.deleteById(1);
        assertThat(productRepository.existsById(1), is(false));
    }
}
