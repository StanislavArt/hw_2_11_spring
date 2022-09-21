package pro.sky.java.course2.spring.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.spring.entity.Product;
import pro.sky.java.course2.spring.exception.ProductAlreadyExistsException;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Service
public class ProductStoreImp implements ProductStore {
    final private HashMap<Integer, Product> productStock;

    public ProductStoreImp() {
        this.productStock = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        productStock.put(11, new Product(11, "Тетрадь"));
        productStock.put(12, new Product(12, "Линейка"));
        productStock.put(13, new Product(13, "Атлас"));
        productStock.put(14, new Product(14, "Циркуль"));
        productStock.put(15, new Product(15, "Ручка"));
    }

    public HashMap<Integer, Product> getProductStock() {
        return productStock;
    }

    @Override
    public void addProduct(Product product) {
        if (productStock.containsKey(product.getId())) {
            throw new ProductAlreadyExistsException();
        }
        productStock.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(Product product) {
        productStock.remove(product.getId());
    }

    @Override
    public void deleteProduct(int idProduct) {
        productStock.remove(idProduct);
    }
}
