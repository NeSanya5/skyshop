package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int prise;
    private int discount;

    public DiscountedProduct(UUID id, String nameProduct, int prise, int discount) {
        super(id, nameProduct);
        if (prise <= 1) {
            throw new IllegalArgumentException("цена не может быть мень 0");
        } else {
            this.prise = prise;
        }
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("скидка указана неправильно");
        }
    }

    @Override
    public int getPrice() {
        return prise - ((prise / 100) * discount);
    }
    @Override
    public String getNameProduct() {
        return super.getNameProduct();
    }

    @Override
    public String toString() {
        return super.toString() + getPrice() + " (Скидка " + discount + "%)";
    }

    @Override
    public String searchTerm() {
        return toString();
    }
}
