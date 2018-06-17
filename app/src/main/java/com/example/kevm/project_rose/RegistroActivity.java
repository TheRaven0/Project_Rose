package com.example.kevm.project_rose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registro_conf;
    private EditText reg_usuario, reg_mail, reg_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registro_conf = (Button)findViewById(R.id.registro_confirmacion);
        reg_usuario = (EditText)findViewById(R.id.registro_username);
        reg_mail = (EditText)findViewById(R.id.registro_mail);
        reg_contraseña = (EditText)findViewById(R.id.registro_password);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registro_confirmacion){

        }
        else;
    }
}
