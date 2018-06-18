package com.example.kevm.project_rose;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kevm.project_rose.fragmentos.NuevoFragment;
import com.example.kevm.project_rose.fragmentos.PrincipalFragment;
import com.example.kevm.project_rose.fragmentos.RecomendadoFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    Button boton1, boton2, boton3;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button)findViewById(R.id.botonUno);
        boton2 = (Button)findViewById(R.id.botonDos);
        boton3 = (Button)findViewById(R.id.botonTres);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PrincipalFragment fr = new PrincipalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenido,fr).commit();
        boton1.setTextColor(getResources().getColor(R.color.colorAccent));

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        usuario = getFromSharedPreferences();
        Toast.makeText(this, "Usuario actual " + usuario, Toast.LENGTH_SHORT).show();

    }

    public void uno (View v)
    {
        PrincipalFragment fr = new PrincipalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenido,fr).commit();
        boton1.setTextColor(getResources().getColor(R.color.colorAccent));
        boton2.setTextColor(getResources().getColor(R.color.white));
        boton3.setTextColor(getResources().getColor(R.color.white));

    }
    public void dos (View v)
    {
        NuevoFragment fr = new NuevoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenido,fr).commit();
        boton1.setTextColor(getResources().getColor(R.color.white));
        boton2.setTextColor(getResources().getColor(R.color.colorAccent));
        boton3.setTextColor(getResources().getColor(R.color.white));
    }
    public void tres (View v)
    {
        RecomendadoFragment fr = new RecomendadoFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Contenido,fr).commit();
        boton1.setTextColor(getResources().getColor(R.color.white));
        boton2.setTextColor(getResources().getColor(R.color.white));
        boton3.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.Home)
        {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.Drama)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "drama");
            startActivity(categoria);
        }

        if(id== R.id.Accion)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "accion");
            startActivity(categoria);
        }

        if(id== R.id.Terror)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "terror");
            startActivity(categoria);
        }

        if(id== R.id.Thriller)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "thriller");
            startActivity(categoria);
        }

        if(id== R.id.Comedia)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "comedia");
            startActivity(categoria);
        }

        if(id== R.id.CienciaFiccion)
        {
            Intent categoria = new Intent(MainActivity.this, catalogo.class);
            categoria.putExtra("nombre_categoria", "ciencia ficcion");
            startActivity(categoria);
        }

        if(id == R.id.Historial)
        {
            Intent historial = new Intent(MainActivity.this, historial.class);
            startActivity(historial);
        }


        if(id == R.id.Logout)
        {
            SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
            preferences.edit().putString("Usuario", "no hay").apply();
            Intent inicioSesion =  new Intent(MainActivity.this, InicioDeSesionActivity.class);
            startActivity(inicioSesion);
            finish();
        }
        return false;
    }

    private String getFromSharedPreferences(){
        SharedPreferences preferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        return preferences.getString("Usuario", "no hay");
    }
}
