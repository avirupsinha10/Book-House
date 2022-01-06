package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {


    EditText mName,mEmail,mPassword;
    SharedPreferences pf;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setTitle("Sign In");

        mName = findViewById(R.id.mUsername);
        mEmail = findViewById(R.id.mEmail);
        mPassword = findViewById(R.id.mPassword);
        login = findViewById(R.id.Login);

        pf = getSharedPreferences("Credentials",MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
            }
        });

    }

    private void signin() {
        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        pf.edit().putString("name",name).apply();
//        pf.edit().putString("email",email).apply();
        pf.edit().putString("password",password).apply();
        pf.edit().putString("login", String.valueOf(true)).apply();

        Toast.makeText(SignInActivity.this, "Logged In Successfully!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(SignInActivity.this,homepage.class);
        startActivity(i);
    }
}