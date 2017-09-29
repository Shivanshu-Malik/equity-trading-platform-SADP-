package com.sapient.sterlingCourier.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ftaran on 8/8/2017.
 */

@Repository
public class GenericDao<T> implements Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<T> getAllArticles() {
        return entityManager.createQuery("FROM" + getClass().getName()).getResultList();
    }

    @Override
    public T getArticleById(int id) {
        return null;
    }

    @Override
    public void addArticle(T t) {
      entityManager.persist(t);
    }

    @Override
    public void updateArticle(T t) {
     entityManager.merge(t);
    }

    @Override
    public void deleteArticle(T t) {
     entityManager.remove(t);
    }
}
