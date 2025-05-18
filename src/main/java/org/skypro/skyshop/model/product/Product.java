package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final UUID id;
    private String nameProduct;

    public Product(UUID id, String nameProduct) {
        this.id = id;
        if (nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неправильное имя для продукта ");
        } else {
            this.nameProduct = nameProduct;
        }
    }
    public abstract int getPrice();

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct);
    }
    @Override
    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
