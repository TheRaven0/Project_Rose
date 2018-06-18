package com.example.kevm.project_rose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class pelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        Intent destino = getIntent();
        String nombre_pelicula=destino.getStringExtra("nombre_pelicula");
        String fecha=destino.getStringExtra("fecha");
        String sinopsis=destino.getStringExtra("sinopsis");
        String reparto=destino.getStringExtra("reparto");

        TextView nombre=(TextView) findViewById(R.id.titulo);
        TextView año=(TextView) findViewById(R.id.año);
        TextView sinopsis_V=(TextView) findViewById(R.id.sinopsis);
        TextView reparto_V=(TextView) findViewById(R.id.reparto);

        nombre.setText(nombre_pelicula);
        año.setText(fecha);
        sinopsis_V.setText(sinopsis);
        reparto_V.setText(reparto);

    }

    public void submitVA (View view) {
        String url = "http://192.168.84.51/factorial.php?algo=";
    }


}
