package com.example.androidmvpexample.login;

import com.example.androidmvpexample.model.User;
/**
 * This interface describes all interactions between Presenter, Model and View
 *
 */

public interface LoginActivityMVP {

    interface View {
        String getFirstName();

        String getLastName();

        void showInputError();

        void setFirstName(String firstName);

        void setLastName(String lastName);

        void showUserSavedMessage();
    }

    interface Presenter {
        void setView(View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    interface Model {
        void createUser(String name, String lastName);

        User getUser();
    }
}
