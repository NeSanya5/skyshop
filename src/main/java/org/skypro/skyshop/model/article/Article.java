package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    String title;
    String text;

    public Article(UUID id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + '\n' + text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(title, ((Article) o).getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getNameProduct() {
        return title;
    }
}
