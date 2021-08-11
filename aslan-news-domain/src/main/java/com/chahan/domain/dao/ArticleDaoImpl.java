package com.chahan.domain.dao;

import com.chahan.domain.config.DbConnectionConfig;
import com.chahan.domain.mapper.Mapper;
import com.chahan.models.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ArticleDaoImpl implements ArticleDao {

    private Mapper mapper = Mapper.getMAPPER();

    private ArticleDaoImpl() {
    }

    private static final ArticleDaoImpl articleDaoImpl = new ArticleDaoImpl();

    public static ArticleDaoImpl getArticleDaoImpl() {
        return articleDaoImpl;
    }

    private static final String SQL_CREATE = "INSERT INTO articles (title, text, date, author_id) values (?,?,?,?)";
    private static final String SQL_FIND_BY_TITLE = "SELECT * FROM articles WHERE title = ?";
    private static final String SQL_READ_All = "SELECT * FROM articles join users on articles.author_id = users.id ORDER BY date DESC";
    private static final String SQL_DELETE = "DELETE FROM articles WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE articles SET title=?, text=?, date=? WHERE id=?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM articles WHERE id = ?";

    @Override
    public void create(Article article, Long id) {

        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_CREATE)) {
            statement.setLong(4, id);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getText());
            statement.setTimestamp(3, Timestamp.from(article.getDate().toInstant(UTC)));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article find(String title) {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_TITLE)) {
            statement.setString(1, title);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Article article = new Article();
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setDate(resultSet.getTimestamp("date").toLocalDateTime().withNano(0));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> readAll() {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_READ_All)) {
            var resultSet = statement.executeQuery();
            List<Article> articleList = new ArrayList<>();
            while (resultSet.next()) {
                articleList.add(mapper.mapArticle(resultSet));
            }
            return articleList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setLong(1, (id));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article find(Long id) {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Article article = new Article();
                article.setTitle(resultSet.getString("title"));
                article.setText(resultSet.getString("text"));
                article.setId(Long.valueOf(resultSet.getString("id")));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void update(Article article) {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getText());
            statement.setTimestamp(3, Timestamp.from(article.getDate().toInstant(UTC)));
            statement.setLong(4, article.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
