package com.chahan.domain.service;

import com.chahan.domain.dao.ArticleDao;
import com.chahan.domain.dao.ArticleDaoImpl;
import com.chahan.domain.exception.ApplicationException;
import com.chahan.models.Article;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao = ArticleDaoImpl.getArticleDaoImpl();

    private ArticleServiceImpl() {

    }

    private static final ArticleService articleService = new ArticleServiceImpl();

    public static ArticleService getArticleService() {
        return articleService;
    }

    @Override
    public Article addArticle(String title, String text, LocalDateTime date, Long id) {
        if (isEmpty(title)) {
            throw new ApplicationException("Fill in the field: title");
        }
        if (isEmpty(text)) {
            throw new ApplicationException("Fill in the field: text");
        }
        Article articleFindExsist = articleDao.find(title);
        if (nonNull(articleFindExsist)) {
            throw new ApplicationException("Article with this title already exist");
        }
        articleDao.create(new Article(title, text, date), id);
        Article article = articleDao.find(title);
        return article;
    }

    @Override
    public Article findArticleByTitle(String title) {
        if (isEmpty(title)) {
            throw new ApplicationException("Fill in the field");
        }
        Article article = articleDao.find(title);
        if (isNull(article)) {
            throw new ApplicationException("Article with this title doesn't exist");
        }
        return article;
    }

    @Override
    public List<Article> readAllArticles() {
        return articleDao.readAll();
    }

    @Override
    public List<Article> deleteArticle(Long id) {
        articleDao.delete(id);
        return articleDao.readAll();
    }

    @Override
    public Article findArticleByID(Long id) {
        return articleDao.find(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.update(article);
    }
}
