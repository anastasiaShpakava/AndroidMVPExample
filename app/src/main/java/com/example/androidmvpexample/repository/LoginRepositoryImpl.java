package com.example.androidmvpexample.repository;

import com.example.androidmvpexample.model.User;

/**
 * This class implements {@link LoginRepository}
 *
 */

public class LoginRepositoryImpl implements LoginRepository {
    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            user = new User("Anna", "Smith");
            user.setId(0);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.user = user;
    }
}
