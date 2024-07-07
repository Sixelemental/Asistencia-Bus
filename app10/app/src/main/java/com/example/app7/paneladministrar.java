package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class paneladministrar extends AppCompatActivity {

    ImageView rutas, usuario, chofer, reportes, lista, buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paneladministrar);

        rutas = findViewById(R.id.imrutas);
        usuario = findViewById(R.id.imagregar);
        chofer = findViewById(R.id.imchofer);
        reportes = findViewById(R.id.imreporte);
        lista = findViewById(R.id.imlista);
        buscar = findViewById(R.id.imbuscar);

        rutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rutaspanel = new Intent(paneladministrar.this, panelrutas.class);
                startActivity(rutaspanel);
            }
        });

        usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usuariopanel = new Intent(paneladministrar.this,panelagregarusuario.class);
                startActivity(usuariopanel);
            }
        });

        chofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choferpanel = new Intent(paneladministrar.this, panelchofer.class);
                startActivity(choferpanel);
            }
        });

        reportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irreportes = new Intent(paneladministrar.this,panelverreporte.class);
                startActivity(irreportes);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listageneral = new Intent(paneladministrar.this,panellista.class);
                startActivity(listageneral);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buscarusario = new Intent(paneladministrar.this,panelbuscar.class);
                startActivity(buscarusario);
            }
        });
    }
}