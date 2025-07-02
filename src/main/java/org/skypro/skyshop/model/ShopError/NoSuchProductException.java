package org.skypro.skyshop.model.ShopError;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super("Такого продукта несуществует");
    }
}
