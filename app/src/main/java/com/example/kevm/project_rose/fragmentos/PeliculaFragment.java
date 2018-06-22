package com.example.kevm.project_rose.fragmentos;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.kevm.project_rose.R;

import org.json.JSONArray;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class PeliculaFragment extends Fragment {

    public PeliculaFragment() {
        // Required empty public constructor
    }

    public String nombre_pelicula, fecha, sinopsis_pelicula, reparto_pelicula, clave, usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pelicula, container, false);

        usuario= getFromSharedPreferences();

        Bundle bundle = getArguments();
        nombre_pelicula = bundle.getString("nombre_pelicula");
        fecha = bundle.getString("fecha");
        sinopsis_pelicula = bundle.getString("sinopsis");
        reparto_pelicula = bundle.getString("reparto");
        clave = bundle.getString("clave");

        TextView nombre=(TextView) view.findViewById(R.id.titulo_peli);
        TextView año=(TextView) view.findViewById(R.id.año_peli);
        TextView sinopsis_V=(TextView) view.findViewById(R.id.sinopsis_peli);
        TextView reparto_V=(TextView) view.findViewById(R.id.reparto_peli);

        nombre.setText(nombre_pelicula);
        año.setText(fecha);
        sinopsis_V.setText(sinopsis_pelicula);
        reparto_V.setText(reparto_pelicula);

        return view;
    }


    public void submitVA_f (View view) {
        String url = "http://192.168.84.51/ver_ahora.php?clave_pelicula="+clave+"&&clave_usuario="+usuario;
        JsonArrayRequest peticion = new JsonArrayRequest
                (
                        Request.Method.POST,
                        url,
                        null,
                        new Response.Listener<JSONArray>()
                        {
                            @Override
                            public void onResponse(JSONArray response)
                            {
                                Toast.makeText(getContext(), "Pelicula agregada",Toast.LENGTH_SHORT).show();


                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) 	{
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue x = Volley.newRequestQueue(getActivity());

        x.add(peticion);

    }

    public void submitVMT_f (View view) {
        String url = "http://192.168.84.51/ver_mas_tarde.php?clave_pelicula="+clave+"&&clave_usuario="+usuario;
        JsonArrayRequest peticion = new JsonArrayRequest
                (
                        Request.Method.POST,
                        url,
                        null,
                        new Response.Listener<JSONArray>()
                        {
                            @Override
                            public void onResponse(JSONArray response)
                            {
                                Toast.makeText(getContext(), "Pelicula agregada",Toast.LENGTH_SHORT).show();


                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) 	{
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue x = Volley.newRequestQueue(getActivity());

        x.add(peticion);

    }

    private String getFromSharedPreferences(){
        SharedPreferences preferences = this.getActivity().getSharedPreferences("user_data", Context.MODE_PRIVATE);
        return preferences.getString("Usuario", "no hay usuario");
    }

}

