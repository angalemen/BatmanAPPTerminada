package com.example.apipokemon;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;


public class VentanaSplash extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(VentanaSplash.this, MainActivity.class);
                startActivity(intent);


                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}

