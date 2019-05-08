package com.example.paginasamarillas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter{
    private static LayoutInflater inflater=null;
    Context contexto;
    String[]nombres;
    String[][] datos;
    int[]datosimg;

    public Adaptador(Context contex, int[] imagenes, String[][] datos){
        this.contexto=contex;
        this.datos=datos;
        this.datosimg=imagenes;
        inflater=(LayoutInflater)contex.getSystemService(contex.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return datosimg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final  View vista=inflater.inflate(R.layout.element,null);
        TextView titulo=(TextView)vista.findViewById(R.id.titulo);
        TextView ubicacion=(TextView)vista.findViewById(R.id.ubicacion);
        TextView telefono=(TextView)vista.findViewById(R.id.telefono);
        ImageView imagen=(ImageView)vista.findViewById(R.id.imageView);
        RatingBar calificacion=(RatingBar)vista.findViewById(R.id.ratingBar);
        titulo.setText(nombres[i]);
        ubicacion.setText(datos[i][1]);
        telefono.setText(datos[i][2]);
        imagen.setImageResource(datosimg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));
        imagen.setTag(i);

        return vista;
    }
}
