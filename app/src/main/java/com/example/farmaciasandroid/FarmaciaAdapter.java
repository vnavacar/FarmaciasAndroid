package com.example.farmaciasandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;

public class FarmaciaAdapter extends ArrayAdapter<Farmacia> {
    public FarmaciaAdapter(@NonNull Context context, int resource, @NonNull List<Farmacia> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.farmacia, parent, false);
        }
        Farmacia farmacia = getItem(position);
        TextView nombre = view.findViewById(R.id.nombre);
        TextView telefono = view.findViewById(R.id.telefono);
        //TextView latitud = view.findViewById(R.id.latitudFarmacia);
        //TextView longitud = view.findViewById(R.id.longitudFarmacia);
        nombre.setText(farmacia.getTitulo());
        telefono.setText(farmacia.getTelefono());
        //latitud.setText(farmacia.getLatitud());
        //longitud.setText(farmacia.getLongitud());
        return view;
    }
}

