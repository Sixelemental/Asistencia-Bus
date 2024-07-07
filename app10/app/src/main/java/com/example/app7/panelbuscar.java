package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class panelbuscar extends AppCompatActivity {

    Button buscar, reportar;
    TextView buscarnombre, buscarcodigo, buscarsituacion, buscarcarrera;
    EditText ingresardni;
    ImageView buscarfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelbuscar);

        buscar = findViewById(R.id.btnbuscarusuario);
        reportar = findViewById(R.id.btnreportarusuario);
        buscarnombre = findViewById(R.id.txtbuscarnombre);
        buscarcodigo = findViewById(R.id.txtbuscarcodigo);
        buscarcarrera = findViewById(R.id.txtbuscarcarrera);
        buscarsituacion = findViewById(R.id.txtbuscarsituacion);
        ingresardni = findViewById(R.id.etingresadnibuscar);
        buscarfoto = findViewById(R.id.imbuscarusuario);

        reportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irreportar = new Intent(panelbuscar.this, panelreporte.class);
                startActivity(irreportar);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = ingresardni.getText().toString();
                buscarUsuario(dni);
            }
        });
    }

    private void buscarUsuario(String dni) {
        switch (dni) {
            case "70602726":
                buscarnombre.setText("Carlos Eleodoro Romero Cruz");
                buscarcodigo.setText("2002010200");
                buscarsituacion.setText("Estudiante");
                buscarcarrera.setText("Ing. de sistemas");
                buscarfoto.setImageResource(R.drawable.juandi);
                break;
            case "73798883":
                buscarnombre.setText("Gilda Isabel Saavedra Vasquez");
                buscarcodigo.setText("2002010208");
                buscarsituacion.setText("Egresada");
                buscarcarrera.setText("Ing. de sistemas");
                buscarfoto.setImageResource(R.drawable.isa);
                break;
            case "72752672":
                buscarnombre.setText("Juan Diego Avila Carrillo");
                buscarcodigo.setText("2002010016");
                buscarsituacion.setText("Estudiante");
                buscarcarrera.setText("Contabilidad");
                buscarfoto.setImageResource(R.drawable.foto1);
                break;
            default:
                buscarnombre.setText("No encontrado");
                buscarcodigo.setText("");
                buscarsituacion.setText("");
                buscarcarrera.setText("");
                buscarfoto.setImageResource(0); // O puedes poner una imagen por defecto
                break;
        }
    }
}
