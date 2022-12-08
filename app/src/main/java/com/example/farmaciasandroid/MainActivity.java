package com.example.farmaciasandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.farmaciasandroid.Constantes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Farmacia> farmacias;
    private FarmaciaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvIncidencias = (ListView) findViewById(R.id.lvIncidencias);
        farmacias = new ArrayList<>();
        adapter = new FarmaciaAdapter(this, farmacias);
        lvIncidencias.setAdapter(adapter);
    }


}