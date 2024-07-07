package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class panelrutas extends AppCompatActivity {

    String opcionSeleccionada;
    Spinner eliminarruta;
    Button actualizar,agregar,eliminar;
    EditText ingresarlink, ingresarruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelrutas);

        eliminarruta = findViewById(R.id.speliminar);
        actualizar = findViewById(R.id.btnactualizarruta);
        agregar = findViewById(R.id.btnagregarruta);
        eliminar = findViewById(R.id.btneliminarruta);

        ingresarlink = findViewById(R.id.etingresarlinknuevo);
        ingresarruta = findViewById(R.id.etingresarrutanueva);

        String[] rutasantiguas = {"Chincha/Universidad", "Quilmaná/Universidad","Lunahuaná/Universidad","Mala/Universidad"};
        ArrayAdapter<String> opcionesantiguas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rutasantiguas);
        opcionesantiguas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eliminarruta.setAdapter(opcionesantiguas);

        eliminarruta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
               opcionSeleccionada = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelrutas.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });//fin de mostrar la eleccion


        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rutaacftualizar = ingresarlink.getText().toString();
                Toast.makeText(panelrutas.this,"La dirección de la ruta web ha sido actualizada",Toast.LENGTH_SHORT).show();
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rutaingresar = ingresarruta.getText().toString();
                Toast.makeText(panelrutas.this,"La nueva ruta ha sido agregada",Toast.LENGTH_SHORT).show();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(panelrutas.this,"LA ruta "+ opcionSeleccionada+" ha sido eliminada",Toast.LENGTH_SHORT).show();
            }
        });


    }
}