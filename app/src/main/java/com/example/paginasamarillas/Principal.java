package com.example.paginasamarillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {
    ListView lista;
    EditText buscar;
    ArrayAdapter<String>adapter;
    String nombre[]={"Chick-fil-A","Quizine","Gastronaut","Robin Food","StellWerk","BullFish","Sushi","Steack HOUSE","Slogan Hero","Winner&&Pepper"};
    String[][]datos={
            {"Chick-fil-A","Jirón Ancash 2479 El Agustino","(01)5133355","7",
             "Chick-fil-A es una cadena de restaurantes con sede en College Park, Georgia, que se especializa en pollo. Es la segunda cadena de restaurantes basada en pollo de comida rápida en los Estados Unidos. ","chickenal@gmail.com","https://www.chick-fil-a.com/Locations/FL/Pines-and-Flamingo"},
            {"Quizine","Av. Nicolás Ayllón 3012, Santa Anita 15023","(01) 6112345","8",
             "Quizine ofrece opciones de limpieza rápida y saludable para todos los gustos. Nuestras comidas exclusivas proporcionan una gran combinación de proteínas magras, carbohidratos saludables y vegetales frescos diseñados para complementar cualquier estilo de vida o régimen de entrenamiento. ","correo","pagina_web","compratir"},
            {"Gastronaut","Av. la Fontana 790, La Molina 15024","(01) 2069745","5",
             "Gastronaut  ofrece  servicion  de cocina a nivel mundial con las mejores recetas en diversos tipos de comidad ","correo","pagina_web","compratir"},
            {"Robin Food","Calle Las Begonias 785, San Isidro 15046","(01) 5137260","4",
             "Robin Food es una representación original de la cocina peruana creativa y que no “es” sino que sigue “siendo”. Son considerados como el reflejo de las primeras innovaciones en la gastronomía que hoy en día, se convirtieron en Tradiciones luego de investigaciones que añaden el ingenio y la pasión por la comida.","correo","pagina_web","compratir"},
            {"StellWerk","Av. Javier Prado Este 4200, Santiago de Surco 15023","515133355","5",
             "El Restaurante EStellWerk ubicado en el distrito de Surco, comparte sus típicas especialidades de la parrilla uruguaya y te acoge en sus cálidos ambientes con la compañía precisa de la música latinoamericana.Si quieres conocer más de la vida platense, entonces aquí tienes un buen lugar.","correo","pagina_web","compratir"},
            {"BullFish","Av Alfredo Mendiola 3698, Independencia 15311","(01) 5117800","7",
             "  BullFish es un espacio en donde encontrarás una exquisita variedad en carnes y brasas que te conquistará desde el primer momento. La fusión de la sazón peruana y el conocimiento argentino dan como resultado una parrilla excepcional que te proporcionará una experiencia sorprendente.","correo","pagina_web","compratir"},
            {"Sushi","Av. Javier Prado Este 4715, La Molina 15023","(01) 7173473","8",
                    "El Restaurante Furai Sushi está la Molina y te ofrece una variedad de preparaciones de la culinaria japonesa como el Chicke katsu, el Gowasu obento, los makis, gyozas, sopas y mucho más. También puedes venir con tus amigos luego de la oficina o durante un fin de semana y disfrutar de su barra libre de rolls.","correo","pagina_web","compratir"},
            {"Steack HOUSE","Jirón de la Unión 599, Cercado de Lima 15001","(01) 5123163","5",
                    "Steack House es una cadena de restaurantes que, desde hace 7 años, encanta el paladar de los peruanos con deliciosos y variados platos, entre los que destacan especialidades como los anticuchos y el pollo pellejo galleta. Sus instalaciones resaltan por manejar un concepto tipo mercado, distinto a lo que estamos acostumbrados y que ha logrado encantar a quienes lo visitan.","correo","pagina_web","compratir"},
            {"Slogan Hero","Av. Arequipa 2250, Lince 15046","(01) 8152123","8",
                    "el Restaurante Slogan Hero es un encantador espacio especializado en la exquisita cocina peruana. Este amplio y acogedor lugar tiene la característica de presentar un show de baile y música tradicional que acompaña tu comida, solicitada en buffet o a la carta.","correo","pagina_web","compratir"},
            {"Winner&&Pepper","Av. Alfredo Benavides 1791, Miraflores 15048","(01) 8152123","8",
                    "El restaurante se basa en la comida ipica de mexico con diversas bariedad de comida picante","correo","pagina_web","compratir"}
    };
    int[] datosimg={R.drawable.imagen1,R.drawable.imagen2,R.drawable.imagen3,
                    R.drawable.imagen4,R.drawable.imagen5,R.drawable.imagen6,
                    R.drawable.imagen7,R.drawable.imagen8,R.drawable.imagen9,
                    R.drawable.imagen10};
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lista=(ListView)findViewById(R.id.lista);
        buscar=(EditText)findViewById(R.id.editText);
        lista.setAdapter(new Adaptador(this, datosimg, datos));
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nombre);
        lista.setAdapter(adapter);
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visiondetallle =new Intent(view.getContext(),Detalle.class);
                visiondetallle.putExtra("TITULO",datos[position][0]);
                visiondetallle.putExtra("descripcion",datos[position][4]);
                visiondetallle.putExtra("imagen",datosimg[position]);
                startActivity(visiondetallle);
            }
        });
    }

}
