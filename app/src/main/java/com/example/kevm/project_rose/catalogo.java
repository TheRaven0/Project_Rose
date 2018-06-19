package com.example.kevm.project_rose;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
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


public class catalogo extends AppCompatActivity {

    String categoria;
    GridLayout mainGrid;
    TextView pelicula1,pelicula2,pelicula3,pelicula4,pelicula5;
    String peli1,peli2,peli3,peli4,peli5,fecha1,fecha2,fecha3,fecha4,fecha5,sinopsis1,sinopsis2,sinopsis3,sinopsis4,sinopsis5,reparto1,reparto2,reparto3,reparto4,reparto5,clave1,clave2,clave3,clave4,clave5;
    private GridLayout singleEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        Intent receive = getIntent();
        categoria = receive.getStringExtra("nombre_categoria");

        pelicula1= (TextView) findViewById (R.id.pelicula1);
        pelicula2= (TextView) findViewById (R.id.pelicula2);
        pelicula3= (TextView) findViewById (R.id.pelicula3);
        pelicula4= (TextView) findViewById (R.id.pelicula4);
        pelicula5= (TextView) findViewById (R.id.pelicula5);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        String url  = "http://192.168.84.51/peliculas.php";

        JsonArrayRequest peticion = new JsonArrayRequest
                (
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONArray>()
                        {
                            @Override
                            public void onResponse(JSONArray response)
                            {
                                try {
                                    pelicula1.setText("" + response.getJSONObject(0).getString("Nombre1"));
                                    pelicula2.setText("" + response.getJSONObject(11).getString("Nombre2"));
                                    pelicula3.setText("" + response.getJSONObject(22).getString("Nombre3"));
                                    pelicula4.setText("" + response.getJSONObject(33).getString("Nombre4"));
                                    pelicula5.setText("" + response.getJSONObject(44).getString("Nombre5"));

                                    peli1= (response.getJSONObject(1).getString("Nombre1"));
                                    peli2= (response.getJSONObject(14).getString("Nombre2"));
                                    peli3= (response.getJSONObject(27).getString("Nombre3"));
                                    peli4= (response.getJSONObject(40).getString("Nombre4"));
                                    peli5= (response.getJSONObject(53).getString("Nombre5"));
                                    fecha1=(response.getJSONObject(5).getString("Fecha de estreno1"));
                                    fecha2=(response.getJSONObject(18).getString("Fecha de estreno2"));
                                    fecha3=(response.getJSONObject(31).getString("Fecha de estreno3"));
                                    fecha4=(response.getJSONObject(44).getString("Fecha de estreno4"));
                                    sinopsis1=(response.getJSONObject(3).getString("Sinopsis1"));
                                    sinopsis2=(response.getJSONObject(16).getString("Sinopsis2"));
                                    sinopsis3=(response.getJSONObject(29).getString("Sinopsis3"));
                                    sinopsis4=(response.getJSONObject(42).getString("Sinopsis4"));
                                    sinopsis5=(response.getJSONObject(55).getString("Sinopsis5"));
                                    reparto1=(response.getJSONObject(4).getString("reparto1"));
                                    reparto2=(response.getJSONObject(17).getString("reparto2"));
                                    reparto3=(response.getJSONObject(30).getString("reparto3"));
                                    reparto4=(response.getJSONObject(43).getString("reparto4"));
                                    reparto5=(response.getJSONObject(56).getString("reparto5"));
                                    clave1=(response.getJSONObject(0).getString("Clave1"));
                                    clave2=(response.getJSONObject(13).getString("Clave2"));
                                    clave3=(response.getJSONObject(26).getString("Clave3"));
                                    clave4=(response.getJSONObject(39).getString("Clave4"));
                                    clave5=(response.getJSONObject(52).getString("Clave5"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) 	{
                        Toast.makeText(catalogo.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue x = Volley.newRequestQueue(catalogo.this);

        x.add(peticion);


    }

    public void setSingleEvent(GridLayout singleEvent) {
        this.singleEvent = singleEvent;
        for (int i=0;i< mainGrid.getChildCount();i++){
            CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int finali=i;
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(finali==0) {
                        Intent intent= new Intent (catalogo.this, pelicula.class);
                       intent.putExtra("nombre_pelicula", peli1);
                        intent.putExtra("fecha", fecha1);
                        intent.putExtra("sinopsis", sinopsis1);
                        intent.putExtra("reparto", reparto1);
                        intent.putExtra("clave", clave1);
                        startActivity(intent);
                    }else if(finali==1) {
                        Intent intent= new Intent (catalogo.this, pelicula.class);
                        intent.putExtra("nombre_pelicula", peli2);
                        intent.putExtra("fecha", fecha2);
                        intent.putExtra("sinopsis", sinopsis2);
                        intent.putExtra("reparto", reparto2);
                        intent.putExtra("clave", clave2);
                        startActivity(intent);
                    }else if(finali==2) {
                        Intent intent= new Intent (catalogo.this, pelicula.class);
                        intent.putExtra("nombre_pelicula", peli3);
                        intent.putExtra("fecha", fecha3);
                        intent.putExtra("sinopsis", sinopsis3);
                        intent.putExtra("reparto", reparto3);
                        intent.putExtra("clave", clave3);
                        startActivity(intent);
                    }else if(finali==3) {
                      Intent intent= new Intent (catalogo.this, pelicula.class);
                        intent.putExtra("nombre_pelicula", peli4);
                        intent.putExtra("fecha", fecha4);
                        intent.putExtra("sinopsis", sinopsis4);
                        intent.putExtra("reparto", reparto4);
                        intent.putExtra("clave", clave4);
                        startActivity(intent);
                    }else if(finali==4) {
                        Intent intent= new Intent (catalogo.this, pelicula.class);
                        intent.putExtra("nombre_pelicula", peli5);
                        intent.putExtra("fecha", fecha5);
                        intent.putExtra("sinopsis", sinopsis5);
                        intent.putExtra("reparto", reparto5);
                        intent.putExtra("clave", clave5);
                        startActivity(intent);
                        }else{
                            Toast.makeText(catalogo.this, "pelicula no disponible",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            );
        }
    }
}