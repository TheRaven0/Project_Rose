package com.example.kevm.project_rose;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InicioDeSesionActivity extends AppCompatActivity implements View.OnClickListener{

    private Button ingresar, registro;
    private EditText usuario, contraseña;
    private String BDuser, BDpassword;
    String Tusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_de_sesion);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);


        ingresar = (Button)findViewById(R.id.ingresar);
        registro = (Button)findViewById(R.id.registro);
        usuario = (EditText)findViewById(R.id.inicio_username);
        contraseña = (EditText)findViewById(R.id.inicio_password);

        Tusuario = getFromSharedPreferences();
        Toast.makeText(this, "Usuario actual " + Tusuario, Toast.LENGTH_SHORT).show();

        ingresar.setOnClickListener(this);
        registro.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ingresar:

                // consulta a BD (aquí va)
                BDuser = "Kevin";
                BDpassword = "123";
                if (usuario.getText().toString().equals(BDuser) && contraseña.getText().toString().equals(BDpassword)){
                    saveLoginSharedPreferences();

                    Intent Main = new Intent(InicioDeSesionActivity.this, MainActivity.class);
                    startActivity(Main);
                    finish();
                }
                else if(usuario.getText().toString().isEmpty()) Toast.makeText(this, "El Usuario está vacío", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();

                break;
            case R.id.registro:
                Intent Registro = new Intent(InicioDeSesionActivity.this, RegistroActivity.class);
                startActivity(Registro);
                break;

                default:

        }
    }

    public void saveLoginSharedPreferences(){
        SharedPreferences sharpref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharpref.edit();
        editor.putString("Usuario", usuario.getText().toString());
        editor.commit();
    }

    private String getFromSharedPreferences(){
        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        return preferences.getString("Usuario", "no hay usuario");
    }
}
