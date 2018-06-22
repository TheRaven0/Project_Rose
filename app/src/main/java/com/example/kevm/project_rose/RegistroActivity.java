package com.example.kevm.project_rose;

import android.content.Intent;
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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registro_conf;
    private EditText reg_usuario, reg_mail, reg_contraseña;
    String url, respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registro_conf = (Button)findViewById(R.id.registro_confirmacion);
        reg_usuario = (EditText)findViewById(R.id.registro_username);
        reg_mail = (EditText)findViewById(R.id.registro_mail);
        reg_contraseña = (EditText)findViewById(R.id.registro_password);

        url = "http://192.168.71.2/user_insert.php?usuario=" + reg_usuario.getText().toString()
                + "&email=" + reg_mail.getText().toString() + "&contrasena=" + reg_contraseña.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registro_confirmacion){
            if (reg_usuario.getText().toString().isEmpty()
                    || reg_mail.getText().toString().isEmpty()
                    || reg_contraseña.getText().toString().isEmpty()){
                Toast.makeText(this, "No puede dejar campos vacíos", Toast.LENGTH_SHORT).show();
            }

            else {
                final JsonObjectRequest peticion = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    respuesta = response.getString("resultado");
                                    Toast.makeText(RegistroActivity.this, "" + respuesta, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegistroActivity.this, InicioDeSesionActivity.class);
                                    startActivity(intent);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(RegistroActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                );

                RequestQueue x = Volley.newRequestQueue(this);
                x.add(peticion);

            }
        }
        else;
    }
}
