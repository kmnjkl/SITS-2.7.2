package com.lkjuhkmnop.sits_272;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    TextView login, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login = findViewById(R.id.signup_login);
        password = findViewById(R.id.signup_password);
        button = findViewById(R.id.signup_button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String newLogin = login.getText().toString();
        String newPassword = password.getText().toString();
        Intent res = new Intent();
        res.putExtra("new_login", newLogin);
        res.putExtra("new_password", newPassword);
        setResult(RESULT_OK, res);
        finish();
    }
}