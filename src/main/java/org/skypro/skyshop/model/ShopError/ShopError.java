package org.skypro.skyshop.model.ShopError;

public class ShopError {
    final int code;
    final String message;

    public ShopError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
