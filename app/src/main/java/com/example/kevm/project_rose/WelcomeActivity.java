package com.example.kevm.project_rose;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends Activity {
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Esconder barra de título
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                if (activityToStart()) {
                    Intent homeIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                }
                else {
                    Intent sesionIntent = new Intent(WelcomeActivity.this, InicioDeSesionActivity.class);
                    startActivity(sesionIntent);
                }
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private boolean activityToStart(){
        String usuario;
        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        usuario = preferences.getString("Usuario", "no hay");
        return !(usuario.equals("no hay"));
    }

}
