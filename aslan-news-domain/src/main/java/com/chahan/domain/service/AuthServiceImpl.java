package com.chahan.domain.service;

import com.chahan.domain.dao.UserDao;
import com.chahan.domain.dao.UserDaoImpl;
import com.chahan.domain.exception.LoginException;
import com.chahan.models.User;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AuthServiceImpl implements AuthService {

    private UserDao userDao = UserDaoImpl.getUserDao();

    private AuthServiceImpl() {
    }

    private static final AuthServiceImpl loginServiceImpl = new AuthServiceImpl();

    public static AuthServiceImpl getLoginServiceImpl() {
        return loginServiceImpl;
    }

    @Override
    public User signIn(String username, String password) {
        if (isEmpty(username) || isEmpty((password))) {
            throw new LoginException("Fill in all the fields");
        }
        User user = userDao.read(username);
        if (isNull(user)) {
            throw new LoginException("The user doesn't exist");
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginException("Wrong password");
        }
        return user;
    }

    @Override
    public User signUp(String username, String password, String repeatPassword) {
        if (isEmpty(username) || isEmpty(password)) {
            throw new LoginException("Fill in all the fields");
        }
        User user = userDao.read(username);
        if (nonNull(user)) {
            throw new LoginException("User with this username already exists");
        }
        if (!password.equals(repeatPassword)) {
            throw new LoginException("Passwords do not match");
        }
        userDao.create(new User(username, password));
        return userDao.read(username);
    }
}
