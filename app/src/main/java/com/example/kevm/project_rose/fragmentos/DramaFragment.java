package com.example.kevm.project_rose.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.kevm.project_rose.R;
import com.example.kevm.project_rose.catalogo;
import com.example.kevm.project_rose.pelicula;

import org.json.JSONArray;
import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 */
public class DramaFragment extends Fragment {
    String categoria;
    GridLayout mainGrid;
    TextView pelicula1,pelicula2,pelicula3,pelicula4,pelicula5, catalogo_nombre;
    String peli1,peli2,peli3,peli4,peli5,fecha1,fecha2,fecha3,fecha4,fecha5,sinopsis1,sinopsis2,sinopsis3,sinopsis4,sinopsis5,reparto1,reparto2,reparto3,reparto4,reparto5,clave1,clave2,clave3,clave4,clave5;
    private GridLayout singleEvent;

    public DramaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drama, container, false);

        Bundle bundle = getArguments();
        categoria = bundle.getString("categoria");
        catalogo_nombre = (TextView) view.findViewById(R.id.textView_dr);
        catalogo_nombre.setText(categoria);

        pelicula1= (TextView) view.findViewById (R.id.pelicula1_dr);
        pelicula2= (TextView) view.findViewById (R.id.pelicula2_dr);
        pelicula3= (TextView) view.findViewById (R.id.pelicula3_dr);
        pelicula4= (TextView) view.findViewById (R.id.pelicula4_dr);
        pelicula5= (TextView) view.findViewById (R.id.pelicula5_dr);

        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        String url  = "http://192.168.71.2/catalogo2.php?genero=" + categoria;

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
                                    pelicula2.setText("" + response.getJSONObject(1).getString("Nombre2"));
                                    pelicula3.setText("" + response.getJSONObject(2).getString("Nombre3"));
                                    pelicula4.setText("" + response.getJSONObject(3).getString("Nombre4"));
                                    pelicula5.setText("" + response.getJSONObject(4).getString("Nombre5"));

                                    peli1= (response.getJSONObject(0).getString("Nombre1"));
                                    peli2= (response.getJSONObject(1).getString("Nombre2"));
                                    peli3= (response.getJSONObject(2).getString("Nombre3"));
                                    peli4= (response.getJSONObject(3).getString("Nombre4"));
                                    peli5= (response.getJSONObject(4).getString("Nombre5"));
                                    fecha1=(response.getJSONObject(0).getString("Fecha de estreno1"));
                                    fecha2=(response.getJSONObject(1).getString("Fecha de estreno2"));
                                    fecha3=(response.getJSONObject(2).getString("Fecha de estreno3"));
                                    fecha4=(response.getJSONObject(3).getString("Fecha de estreno4"));
                                    fecha5=(response.getJSONObject(4).getString("Fecha de estreno5"));
                                    sinopsis1=(response.getJSONObject(0).getString("Sinopsis1"));
                                    sinopsis2=(response.getJSONObject(1).getString("Sinopsis2"));
                                    sinopsis3=(response.getJSONObject(2).getString("Sinopsis3"));
                                    sinopsis4=(response.getJSONObject(3).getString("Sinopsis4"));
                                    sinopsis5=(response.getJSONObject(4).getString("Sinopsis5"));
                                    reparto1=(response.getJSONObject(0).getString("reparto1"));
                                    reparto2=(response.getJSONObject(1).getString("reparto2"));
                                    reparto3=(response.getJSONObject(2).getString("reparto3"));
                                    reparto4=(response.getJSONObject(3).getString("reparto4"));
                                    reparto5=(response.getJSONObject(4).getString("reparto5"));
                                    clave1=(response.getJSONObject(0).getString("Clave1"));
                                    clave2=(response.getJSONObject(1).getString("Clave2"));
                                    clave3=(response.getJSONObject(2).getString("Clave3"));
                                    clave4=(response.getJSONObject(3).getString("Clave4"));
                                    clave5=(response.getJSONObject(4).getString("Clave5"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) 	{
                        Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue x = Volley.newRequestQueue(getActivity());

        x.add(peticion);

        return view;
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
                        Toast.makeText(getContext(), "Pelicula seleccionada", Toast.LENGTH_SHORT).show();
                        PeliculaFragment frag = new PeliculaFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre_pelicula", peli1);
                        bundle.putString("fecha", fecha1);
                        bundle.putString("sinopsis", sinopsis1);
                        bundle.putString("reparto", reparto1);
                        bundle.putString("clave", clave1);
                        frag.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Contenido,frag).commit();
                    }else if(finali==1) {
                        Toast.makeText(getContext(), "Pelicula seleccionada", Toast.LENGTH_SHORT).show();
                        PeliculaFragment frag = new PeliculaFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre_pelicula", peli2);
                        bundle.putString("fecha", fecha2);
                        bundle.putString("sinopsis", sinopsis2);
                        bundle.putString("reparto", reparto2);
                        bundle.putString("clave", clave2);
                        frag.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Contenido,frag).commit();
                    }else if(finali==2) {
                        Toast.makeText(getContext(), "Pelicula seleccionada", Toast.LENGTH_SHORT).show();
                        PeliculaFragment frag = new PeliculaFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre_pelicula", peli3);
                        bundle.putString("fecha", fecha3);
                        bundle.putString("sinopsis", sinopsis3);
                        bundle.putString("reparto", reparto3);
                        bundle.putString("clave", clave3);
                        frag.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Contenido,frag).commit();
                    }else if(finali==3) {
                        Toast.makeText(getContext(), "Pelicula seleccionada", Toast.LENGTH_SHORT).show();
                        PeliculaFragment frag = new PeliculaFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre_pelicula", peli4);
                        bundle.putString("fecha", fecha4);
                        bundle.putString("sinopsis", sinopsis4);
                        bundle.putString("reparto", reparto4);
                        bundle.putString("clave", clave4);
                        frag.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Contenido,frag).commit();
                    }else if(finali==4) {
                        Toast.makeText(getContext(), "Pelicula seleccionada", Toast.LENGTH_SHORT).show();
                        PeliculaFragment frag = new PeliculaFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre_pelicula", peli5);
                        bundle.putString("fecha", fecha5);
                        bundle.putString("sinopsis", sinopsis5);
                        bundle.putString("reparto", reparto5);
                        bundle.putString("clave", clave5);
                        frag.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.Contenido,frag).commit();
                    }else{
                        Toast.makeText(getActivity(), "pelicula no disponible",Toast.LENGTH_SHORT).show();
                        }
                }
            }
            );
        }


    }
}
