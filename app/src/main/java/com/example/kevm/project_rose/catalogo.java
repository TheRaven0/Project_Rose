/*package com.example.kevm.project_rose;

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
    private GridLayout singleEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
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
                                    pelicula1.setText("" + response.getJSONObject(0).getInt("nombre1"));
                                    pelicula1.setText("" + response.getJSONObject(0).getInt("nombre1"));
                                    pelicula1.setText("" + response.getJSONObject(0).getInt("nombre1"));
                                    pelicula1.setText("" + response.getJSONObject(0).getInt("nombre1"));
                                    pelicula1.setText("" + response.getJSONObject(0).getInt("nombre1"));


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
                        startActivity(intent);
                    }
                    }
                }
            );
        }
    }
}
*/