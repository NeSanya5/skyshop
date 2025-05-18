package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    UUID getId();
    String searchTerm();
    String getContentType();
    String getNameProduct();
    default String getStringRepresentation() {
        return getNameProduct() + " " + getContentType();
    }
}
