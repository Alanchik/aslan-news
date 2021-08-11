package com.chahan.domain.mapper;

import com.chahan.models.Article;
import com.chahan.models.User;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Mapper {

    private static final Mapper MAPPER = new Mapper();

    public static Mapper getMAPPER() {
        return MAPPER;
    }

    public Article mapArticle(ResultSet resultSet) throws SQLException {
        Article article = new Article();
        article.setTitle(resultSet.getString("title"));
        article.setText(resultSet.getString("text"));
        article.setDate(resultSet.getTimestamp("date").toLocalDateTime().withNano(0));
        article.setId(Long.valueOf(resultSet.getString("id")));
        User author = new User();
        author.setId(resultSet.getLong("author_id"));
        author.setUsername(resultSet.getString("username"));
        article.setAuthor(author);
        return article;
    }
}
