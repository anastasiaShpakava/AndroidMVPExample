package com.example.androidmvpexample.repository;

import com.example.androidmvpexample.model.User;

/**
 * Class is for actions with {@link User}
 *
 */

public interface LoginRepository {
    User getUser();

    void saveUser(User user);
}
