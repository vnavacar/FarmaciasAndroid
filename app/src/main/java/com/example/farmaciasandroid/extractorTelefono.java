package com.example.farmaciasandroid;

import android.util.Log;

public class extractorTelefono {
    public static String extraerTelefono(String telefono){
        String telefonoExtraido = "";
        //se busca a partir de "Teléfono: "
        //Log.i("String:", telefono);

        //int posicion = telefono.indexOf("Teléfono: "); //seria correcto si java reconociera las tildes
        int posicion = telefono.indexOf("Tel�fono: "); //java no reconoce el caracter �
        //si no se encuentra, se busca a partir de "Teléfono:"
        if(posicion == -1){
            return "No se ha encontrado el teléfono";
        }
        //se extraen los 9 caracteres siguientes
        for(int i = posicion + 10; i < posicion + 19; i++){
            telefonoExtraido += telefono.charAt(i);
        }
        //Log.i("telefonoExtraido", telefonoExtraido);

        return telefonoExtraido;
    }
}

