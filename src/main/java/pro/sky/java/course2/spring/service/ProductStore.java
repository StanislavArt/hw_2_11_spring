package pro.sky.java.course2.spring.service;

import pro.sky.java.course2.spring.entity.Product;

import java.util.HashMap;

public interface ProductStore {
    void addProduct(Product product);
    void deleteProduct(Product product);
    void deleteProduct(int idProduct);
    HashMap<Integer, Product> getProductStock();
}
