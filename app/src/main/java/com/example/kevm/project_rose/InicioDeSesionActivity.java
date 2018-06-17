package com.example.kevm.project_rose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioDeSesionActivity extends AppCompatActivity implements View.OnClickListener{

    private Button ingresar, registro;
    private EditText usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_de_sesion);

        ingresar = (Button)findViewById(R.id.ingresar);
        registro = (Button)findViewById(R.id.registro);
        usuario = (EditText)findViewById(R.id.inicio_username);
        contraseña = (EditText)findViewById(R.id.inicio_password);

        ingresar.setOnClickListener(this);
        registro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ingresar:
                break;
            case R.id.registro:
                break;

                default:

        }
    }
}
