package com.example.farmaciasandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ArrayList<Farmacia> farmacias;
    private FarmaciaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farmacias= new ArrayList<Farmacia>();

        ListView lvfarmacias = (ListView) findViewById(R.id.lvFarmacias);

        adapter = new FarmaciaAdapter(this,
                R.layout.farmacia, farmacias);
        lvfarmacias.setAdapter(adapter);
        lvfarmacias.setOnItemClickListener(this);


        DescargaDatos descarga = new DescargaDatos();
        descarga.execute(Constantes.URL);
    }

    @Override
    protected void  onResume() {
        super.onResume();

    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

        Farmacia f1 = farmacias.get(posicion);
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("nombre", f1.getTitulo());
        intent.putExtra("latitud", f1.getLatitud());
        intent.putExtra("longitud", f1.getLongitud());
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private class DescargaDatos extends AsyncTask<String, Void, Void> {

        //private ProgressDialog dialog;
        private String resultado;

        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conexion = (HttpURLConnection)
                        url.openConnection();
                // Lee el fichero de datos y genera una cadena de texto como resultado
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String linea = null;

                while ((linea = br.readLine()) != null)
                    sb.append(linea + "\n");

                conexion.disconnect();
                br.close();
                resultado = sb.toString();

                JSONObject json = new JSONObject(resultado);
                JSONArray jsonArray = json.getJSONArray("features");
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        Farmacia farmacia1=new Farmacia();
                        //Log.i("Farmacia:", jsonArray.getJSONObject(i).toString());
                        //farmacia1.setTitulo(jsonArray.getJSONObject(i).getString("title"));
                        farmacia1.setTitulo(jsonArray.getJSONObject(i).getJSONObject("properties").getString("title"));
                        //farmacia1.setLatitud(jsonArray.getJSONObject(i).getJSONObject("location").getDouble("latitude"));
                        farmacia1.setLatitud(jsonArray.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates").getDouble(1));
                        //farmacia1.setLongitud(jsonArray.getJSONObject(i).getJSONObject("location").getDouble("longitude"));
                        farmacia1.setLongitud(jsonArray.getJSONObject(i).getJSONObject("geometry").getJSONArray("coordinates").getDouble(0));
                        farmacias.add(farmacia1);
                    } catch (JSONException jsone) {
                        jsone.printStackTrace();
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (JSONException jsone) {
                jsone.printStackTrace();
            }
            return null;
        }


    }


}