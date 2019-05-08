package com.example.paginasamarillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        TextView titulo=(TextView)findViewById(R.id.tbtitulo);
        TextView detalle=(TextView)findViewById(R.id.tbdescripcion);
        ImageView imagen=(ImageView) findViewById(R.id.imageView3);
        Intent intent=getIntent();
        Bundle b=intent.getExtras();
        if (b!=null){
            titulo.setText(b.getString("TITULO"));
            detalle.setText(b.getString("descripcion"));
            imagen.setImageResource(b.getInt("imagen"));
        }

    }
}
