package com.example.androidmvpexample.dagger;

import com.example.androidmvpexample.login.LoginActivityPresenter;
import com.example.androidmvpexample.model.LoginModel;
import com.example.androidmvpexample.repository.LoginRepository;

import dagger.Component;

@Component(modules = Module.class)
public interface AppComponent {
    LoginRepository getLoginRepository();
    LoginModel getLoginModel();
    LoginActivityPresenter getLoginActivityPresenter();
}
