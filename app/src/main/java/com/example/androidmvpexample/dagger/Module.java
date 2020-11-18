package com.example.androidmvpexample.dagger;

import com.example.androidmvpexample.login.LoginActivityMVP;
import com.example.androidmvpexample.login.LoginActivityPresenter;
import com.example.androidmvpexample.model.LoginModel;
import com.example.androidmvpexample.repository.LoginRepository;
import com.example.androidmvpexample.repository.LoginRepositoryImpl;

import dagger.Provides;

@dagger.Module
public class Module {
    @Provides
    LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    LoginRepository provideLoginRepository() {
        return new LoginRepositoryImpl();
    }
}
