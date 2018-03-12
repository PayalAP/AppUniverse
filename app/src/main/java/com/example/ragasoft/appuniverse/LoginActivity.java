package com.example.ragasoft.appuniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signin = findViewById(R.id.signin_button);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v==signin)
        {
            Intent intent = new Intent(LoginActivity.this,HomeScreenActivity.class);
            startActivity(intent);
        }

    }
}
