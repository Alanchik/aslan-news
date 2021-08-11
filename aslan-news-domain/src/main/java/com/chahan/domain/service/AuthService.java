package com.chahan.domain.service;

import com.chahan.models.User;

public interface AuthService {

     User signIn(String username, String password);
     User signUp(String username, String password, String repeatPassword);
}
