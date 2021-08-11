package com.chahan.domain.service;

import com.chahan.models.Article;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleService {

    Article addArticle(String title, String text, LocalDateTime date, Long id);

    Article findArticleByTitle(String title);

    List<Article> readAllArticles();

    List<Article> deleteArticle(Long id);

    Article findArticleByID(Long id);

    void updateArticle(Article article);
}
