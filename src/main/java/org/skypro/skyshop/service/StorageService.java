package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private Map<UUID, Product> products = new HashMap<>();
    private Map<UUID, Article> articles = new HashMap<>();

    public StorageService(Map<UUID, Product> products, Map<UUID, Article> articls) {
        this.products = productMap();
        this.articles = articleMap();
    }


    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticls() {
        return articles.values();
    }

    public Collection<Searchable> getSearchbleAllStorageService() {
        return Stream.concat(products.values().stream(), articles.values().stream())
                .collect(Collectors.toList());

    }

    public static Map<UUID, Product> productMap() {
        Map<UUID, Product> products = new HashMap<>();
            Product jacket = new DiscountedProduct(UUID.randomUUID(), "Куртка", 8700, 15);
        Product shirt = new DiscountedProduct(UUID.randomUUID(), "Футболка", 1200, 25);
        Product cardigan = new FixPriceProduct(UUID.randomUUID(), "Кофта");
        Product feltBoots = new FixPriceProduct(UUID.randomUUID(), "Валенки");
        Product socks = new SimpleProduct(UUID.randomUUID(), "Носки", 200);
        Product sneakers = new SimpleProduct(UUID.randomUUID(), "Кросовки", 2000);

        products.put(jacket.getId(), jacket);
        products.put(shirt.getId(), shirt);
        products.put(cardigan.getId(), cardigan);
        products.put(feltBoots.getId(), feltBoots);
        products.put(socks.getId(), socks);
        products.put(sneakers.getId(), sneakers);
        return products;
    }

    public static Map<UUID, Article> articleMap() {
        Map<UUID, Article> articls = new HashMap<>();
        Article glasses = new Article(UUID.randomUUID(), "Очки", "Очки -3");
        Article blueSneakers = new Article(UUID.randomUUID(), "Кроссовки", "Кроссовки с размером 42, синего цвета");
        Article gloves = new Article(UUID.randomUUID(),"Перчатки","Перчатки XXXXL размера");
        Article apple = new Article(UUID.randomUUID(),"Яблоко", "Вес:1,5 гб");

        articls.put(glasses.getId(),glasses);
        articls.put(blueSneakers.getId(),blueSneakers);
        articls.put(gloves.getId(),gloves);
        articls.put(apple.getId(),apple);
        return articls;
    }

}


