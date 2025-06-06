package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {
    final UUID id;
    final String name;
    final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId(), searchable.getNameProduct(), searchable.getContentType());
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
