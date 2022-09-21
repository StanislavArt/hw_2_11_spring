package pro.sky.java.course2.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.java.course2.spring.entity.Product;
import pro.sky.java.course2.spring.exception.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class BasketStoreImp implements BasketStore {
    final private HashMap<Product, Integer> basket;  // корзина продуктов
    final private ProductStore productStore;   // склад продуктов

    public BasketStoreImp(ProductStore productStore) {
        this.basket = new HashMap<>();
        this.productStore = productStore;
    }

    @Override
    public String addProducts(String products) {
        String result = "В корзину добавлены товары: <br>";
        int idProduct;
        String[] arrayOfIdProducts = products.split(",");
        for (String idProductString : arrayOfIdProducts) {
            idProduct = Integer.parseInt(idProductString);
            Product product = productStore.getProductStock().get(idProduct);
            if (product == null) {
                throw new ProductNotFoundException();
            }
            result += product + "<br>";
            int quantity = basket.getOrDefault(product, 0);
            basket.put(product, quantity + 1);
        }
        return result;
    }

    @Override
    public String getListProducts() {
        if (basket.isEmpty()) {
            return "Корзина пуста";
        }
        Product product;
        String result = "Содержимое корзины: <br>";
        for (Map.Entry entry : basket.entrySet()) {
            product = (Product) entry.getKey();
            result += product.getName() + " (id = " + product.getId() + "), количество = " + entry.getValue() + "<br>";
        }
        return result;
    }
}
