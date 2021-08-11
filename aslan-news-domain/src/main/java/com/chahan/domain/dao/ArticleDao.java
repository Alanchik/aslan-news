package com.chahan.domain.dao;

import com.chahan.models.Article;

import java.util.List;

public interface ArticleDao {

    void create(Article article, Long id);

    void delete(Long id);

    Article find(String title);

    List<Article> readAll();

    Article find(Long id);

    void update(Article article);
}
