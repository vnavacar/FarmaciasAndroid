package com.example.farmaciasandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FarmaciaAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Farmacia> farmacias;

    public FarmaciaAdapter(Context contexto,
                             ArrayList<Farmacia> farmacias) {

        inflater = LayoutInflater.from(contexto);
        this.farmacias = farmacias;
    }

    static class ViewHolder {
        ImageView icono;
        TextView titulo;
        TextView calle;
        TextView motivo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.farmacia, null);

            holder = new ViewHolder();
            holder.icono = (ImageView) convertView.findViewById(R.id.ivIcono);
            holder.titulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            holder.calle = (TextView) convertView.findViewById(R.id.tvCalle);
            holder.motivo = (TextView) convertView.findViewById(R.id.tvMotivo);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Farmacia farmacia = farmacias.get(position);
        holder.titulo.setText(farmacia.getTitulo());
        holder.calle.setText(farmacia.getCalle());
        holder.motivo.setText(farmacia.getMotivo());

        return convertView;
    }

    @Override
    public int getCount() {
        return farmacias.size();
    }

    @Override
    public Object getItem(int i) {
        return farmacias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return farmacias.get(i).getId();
    }
}