package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int prise;

    public SimpleProduct(UUID id, String nameProduct, int prise) {
        super(id, nameProduct);
        if (prise <= 1) {
            throw new IllegalArgumentException("цена не может быть меньше 0");
        } else {
            this.prise = prise;
        }
    }
    @Override
    public String getNameProduct() {
        return super.getNameProduct();
    }

    public int getPrice(){
        return prise;
    }
    public String toString() {
        return super.toString() + prise;
    }
    @Override
    public String searchTerm() {
        return toString();
    }
}
