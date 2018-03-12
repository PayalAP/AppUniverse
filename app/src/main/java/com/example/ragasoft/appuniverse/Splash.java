package com.example.ragasoft.appuniverse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Splash extends AppCompatActivity
{
    ImageView splashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashLogo = findViewById(R.id.splash_logo);
        splashLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Splash.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
