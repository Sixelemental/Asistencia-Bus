package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

public class panelviaje extends AppCompatActivity {

    Spinner viaje, conductor;
    RadioButton ida, vuelta, manana, tarde, noche;
    Button pasajeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelviaje);

        viaje = findViewById(R.id.idrutasdeviaje);
        conductor = findViewById(R.id.idconductor);
        pasajeros = findViewById(R.id.btnpasajeros);
        ida = findViewById(R.id.rbida);
        vuelta = findViewById(R.id.rbvuelta);
        manana = findViewById(R.id.rbmanana);
        tarde = findViewById(R.id.rbtarde);
        noche = findViewById(R.id.rbnoche);

        // Para los conductores
        String[] choferes = {"Saravia Castilla, Miguel Arturo", "Mendoza Linares, Jaimito Gustavo", "Yalan Garcia, Issac Miguel", "Quispe Castilla, Wilmer Alberto"};
        ArrayAdapter<String> choferesspiner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choferes) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK); // Establecer el color del texto en negro
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK); // Establecer el color del texto en negro
                return view;
            }
        };
        choferesspiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conductor.setAdapter(choferesspiner);

        conductor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcionSeleccionada = parent.getItemAtPosition(position).toString();
                Toast.makeText(panelviaje.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); // Fin de selección del conductor

        // Para las rutas
        String[] opciones = {"Chincha/Universidad", "Quilmaná/Universidad", "Lunahuaná/Universidad", "Mala/Universidad"};
        ArrayAdapter<String> opcionesspiner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK); // Establecer el color del texto en negro
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                textView.setTextColor(Color.BLACK); // Establecer el color del texto en negro
                return view;
            }
        };
        opcionesspiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viaje.setAdapter(opcionesspiner);

        // Mostrar la elección
        viaje.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                String opcionSeleccionada = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelviaje.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        }); // Fin de mostrar la elección

        // Para registrar pasajeros
        pasajeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si se ha seleccionado ida o vuelta
                if (!ida.isChecked() && !vuelta.isChecked()) {
                    Toast.makeText(panelviaje.this, "Debe seleccionar una dirección", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificar si se ha seleccionado mañana, tarde o noche
                if (!manana.isChecked() && !tarde.isChecked() && !noche.isChecked()) {
                    Toast.makeText(panelviaje.this, "Debe seleccionar una ruta", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Si se han pasado ambas verificaciones, proceder al siguiente panel
                Intent pasajerosbus = new Intent(panelviaje.this, panelregistrar.class);
                startActivity(pasajerosbus);
            }
        }); // Fin botón pasajeros
    }
}