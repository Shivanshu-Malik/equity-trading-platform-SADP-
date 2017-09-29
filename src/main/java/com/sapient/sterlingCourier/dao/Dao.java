package com.sapient.sterlingCourier.dao;

import java.util.List;

/**
 * Created by ftaran on 8/8/2017.
 */
public interface Dao<T> {
    List<T> getAllArticles();
    T getArticleById(int id);
    void addArticle(T t);
    void updateArticle(T t);
    void deleteArticle(T t);
}
