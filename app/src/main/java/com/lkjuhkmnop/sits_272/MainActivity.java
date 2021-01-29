package com.lkjuhkmnop.sits_272;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView login, pass, res;
    Button btn;

    private String r_login = "lkj", r_pass = "qwe123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        pass = findViewById(R.id.password);
        res = findViewById(R.id.result);
        btn = findViewById(R.id.signin);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String e_login = login.getText().toString();
        String e_pass = pass.getText().toString();

//        res.setText(e_login + " | " + e_pass + " | " + e_login.equals(r_login) + " | " + e_pass.equals(r_pass));

        if (e_login.equals(r_login) && e_pass.equals(r_pass)) {
            res.setText("Верно");
        } else {
            login.setText("");
            pass.setText("");
            res.setText("");
            Intent intent = new Intent(this, SignUp.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                r_login = data.getStringExtra("new_login");
                r_pass = data.getStringExtra("new_password");
                login.setText(r_login);
        }
    }
}