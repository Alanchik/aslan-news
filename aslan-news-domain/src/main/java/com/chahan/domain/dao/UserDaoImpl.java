package com.chahan.domain.dao;

import com.chahan.domain.config.DbConnectionConfig;
import com.chahan.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.chahan.domain.config.DbConnectionConfig.getConnectionConfig;


public class UserDaoImpl implements UserDao {

    private UserDaoImpl() {
    }

    public static UserDaoImpl getUserDao() {
        return userDaoImpl;
    }

    private static final String SQL_CREATE = "INSERT INTO users (username, password) values (?,?)";
    private static final String SQL_READ = "SELECT * FROM users WHERE username = ?";

    private static final UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public void create(User user) {
        try (Connection connection = getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_CREATE)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            //log
        }
    }

    @Override
    public User read(String username) {
        try (Connection connection = DbConnectionConfig.getConnectionConfig();
             PreparedStatement statement = connection.prepareStatement(SQL_READ)) {
            statement.setString(1, username);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            //log
        }
        return null;
    }
}
