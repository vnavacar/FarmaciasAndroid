package com.example.farmaciasandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FarmaciaAdapter2 extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;

    private int layout;
    private ArrayList<Farmacia> farmacias;

    public FarmaciaAdapter2(Context contexto, int layout, ArrayList<Farmacia> farmacias) {

        this.context = contexto;
        this.layout = layout;
        this.farmacias = farmacias;
    }

    @Override
    public int getCount() {
        return this.farmacias.size();
    }

    @Override
    public Object getItem(int position) {
        return this.farmacias.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    static class ViewHolder {
        private TextView nombre;
        private TextView telefono;
    }

    public View getView(int position,View convertView,ViewGroup parent){

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.farmacia, null);

            holder = new ViewHolder();
            //holder.icono = (ImageView) convertView.findViewById(R.id.ivIcono);
            holder.nombre = (TextView) convertView.findViewById(R.id.nombre);
            holder.telefono = (TextView) convertView.findViewById(R.id.telefono);
            //holder.motivo = (TextView) convertView.findViewById(R.id.tvMotivo);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Farmacia incidencia = farmacias.get(position);
        holder.nombre.setText(incidencia.getTitulo());
        holder.telefono.setText(incidencia.getTelefono());

        return convertView;
    }
}