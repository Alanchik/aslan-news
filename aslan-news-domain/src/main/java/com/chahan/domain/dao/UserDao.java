package com.chahan.domain.dao;

import com.chahan.models.User;

public interface UserDao {

    void create(User user);

    User read(String username);
}
