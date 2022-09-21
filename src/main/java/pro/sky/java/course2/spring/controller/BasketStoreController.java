package pro.sky.java.course2.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.spring.service.BasketStore;

@RestController
@RequestMapping("/order")
public class BasketStoreController {
    final BasketStore basketStore;

    public BasketStoreController(BasketStore basketStore) {
        this.basketStore = basketStore;
    }

    @GetMapping("/add")
    public String addProductsToBasket(@RequestParam("products") String products) {
        return basketStore.addProducts(products);
    }

    @GetMapping("/get")
    public String getProductsFromBasket() {
        return basketStore.getListProducts();
    }

}
