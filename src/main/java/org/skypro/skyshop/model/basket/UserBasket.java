package org.skypro.skyshop.model.basket;

import java.util.List;

public final class UserBasket {
    List<BasketItem> basketItems;
    int total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public int getTotal() {
        return basketItems.stream()
                .mapToInt(i-> i.getCount()*i.getProduct().getPrice())
                .sum();
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }
}
