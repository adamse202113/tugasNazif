package com.adamse.loginnajip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username,Password;
                Username=username.getText().toString();
                Password=password.getText().toString();

                if(Username.equals("admin")&& Password.equals("admin")){
                    Intent login=new Intent(Login.this,Admin.class);
                    startActivity(login);
                    finish();
                }
                if (Username.equals("user") && Password.equals("user")){
                    Intent login = new Intent(Login.this, User.class);
                    startActivity(login);
                    finish();
                }
                else if (Username.isEmpty() && Password.isEmpty()){
                    username.setError("kolom harus diisi");
                    password.setError("kolom harus diisi");
                }
                else if (Username.isEmpty()){
                    username.setError("kolom harus diisi");
                }
                else if (Password.isEmpty()){
                    password.setError("kolom harus diisi");
                }
                else{

                    Snackbar.make(view,"Password dan Username tidak valid",Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}
