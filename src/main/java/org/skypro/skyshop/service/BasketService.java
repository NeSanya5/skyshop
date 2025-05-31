package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BasketService {
    private final StorageService storageService;
    private final ProductBasket productBasket;

    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    public void getProductInBasket(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            productBasket.getProduct(id);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = productBasket.getProductBasket()
                .entrySet()
                .stream()
                .map(i-> new BasketItem( storageService.getProductById(i.getKey()).orElseThrow(),i.getValue()))
                .toList();
        return new UserBasket(items);
    }
}
