package com.example.androidmvpexample.model;

import com.example.androidmvpexample.login.LoginActivityMVP;
import com.example.androidmvpexample.repository.LoginRepository;

/**
 * This class implements {@link LoginActivityMVP.Model}
 *
 */

public class LoginModel implements LoginActivityMVP.Model {
    private LoginRepository loginRepository;

    public LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createUser(String name, String lastName) {
        loginRepository.saveUser(new User(name, lastName));
    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}
