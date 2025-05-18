package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    int FixPrice = 2000;

    public FixPriceProduct(UUID id, String nameProduct) {
        super(id, nameProduct);
    }

    @Override
    public int getPrice() {
        return FixPrice;
    }
    @Override
    public String getNameProduct() {
        return super.getNameProduct();
    }

    @Override
    public String toString() {
        return super.toString() + " Фиксированная цена " + FixPrice;
    }
    @Override
    public String searchTerm() {
        return toString();
    }
}
