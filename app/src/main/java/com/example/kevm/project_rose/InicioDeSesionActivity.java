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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

                String url = "http://192.168.84.51/password_request.php?usuario=" + usuario.getText().toString();

                JsonObjectRequest peticion = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    BDpassword = "";
                                    BDpassword.concat(response.getString("contraseña"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(InicioDeSesionActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                );

                RequestQueue x = Volley.newRequestQueue(this);
                x.add(peticion);
                // consulta a BD (aquí va)

                if (contraseña.getText().toString().equals(BDpassword)){
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

    private void saveLoginSharedPreferences(){
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