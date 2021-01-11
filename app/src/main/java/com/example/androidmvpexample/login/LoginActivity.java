package com.example.androidmvpexample.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvpexample.R;
import com.example.androidmvpexample.dagger.App;
import com.example.androidmvpexample.model.LoginModel;
import com.example.androidmvpexample.repository.LoginRepository;
import com.example.androidmvpexample.repository.LoginRepositoryImpl;


public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {
    private LoginActivityMVP.Presenter presenter;
    private LoginActivityMVP.Model model;
    private LoginRepository repository;
    private EditText firstName;
    private EditText lastName;
    private Button login;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = App.getComponent().getLoginRepository();
        model = App.getComponent().getLoginModel();
        presenter = App.getComponent().getLoginActivityPresenter();

        firstName = findViewById(R.id.loginActivity_firstName_editText);
        lastName = findViewById(R.id.loginActivity_lastName_editText);
        login = findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }


    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First Name or last name cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully", Toast.LENGTH_SHORT).show();
    }
}
