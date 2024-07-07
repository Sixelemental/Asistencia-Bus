package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

public class panelregistrar extends AppCompatActivity {

    Spinner documento;
    EditText numero;
    Button buscar, qr, lista, administrar;
    String delegado;
    String opcionSeleccionada; // Variable para almacenar la selección del Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelregistrar);
        documento = findViewById(R.id.sptipodocumento);
        numero = findViewById(R.id.etnumerodocumento); // Asegúrate de que este ID coincida con el del EditText en tu layout
        buscar = findViewById(R.id.btnbuscar);
        qr = findViewById(R.id.btnqr);
        lista = findViewById(R.id.btnlistadeasistencia);
        administrar = findViewById(R.id.btnadministrar);

        // Leer el valor del delegado desde SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        delegado = preferences.getString("delegado", null);

        // Creando las opciones del Spinner
        String[] opciones = {"Código Universitario", "DNI"};
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
        documento.setAdapter(opcionesspiner);

        // Mostrar la elección
        documento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                opcionSeleccionada = parent.getItemAtPosition(position).toString();

                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelregistrar.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numerousuario = numero.getText().toString().trim();

                if (opcionSeleccionada != null && !opcionSeleccionada.isEmpty() && !numerousuario.isEmpty()) {
                    Intent buscarusuario = new Intent(panelregistrar.this, panelusuario.class);
                    buscarusuario.putExtra("numerobuscarusuario", numerousuario);
                    buscarusuario.putExtra("opcionSeleccionada", opcionSeleccionada); // Pasa la selección del Spinner a la siguiente actividad
                    startActivity(buscarusuario);
                } else {
                    Toast.makeText(panelregistrar.this, "Debe seleccionar un tipo de documento y colocar un número.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buscarqr = new Intent(panelregistrar.this, panelqr.class);
                startActivity(buscarqr);
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listdelegados = new Intent(panelregistrar.this, panelasistenciadelegado.class);
                startActivity(listdelegados);
            }
        });

        administrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(panelregistrar.this, paneladministrar.class);
                startActivity(admin);
            }
        });

        // Verificar el delegado y configurar la visibilidad del botón "administrar"
        if (delegado != null && delegado.equals("2002010208")) {
            administrar.setVisibility(View.VISIBLE);
        } else {
            administrar.setVisibility(View.GONE);
        }
    }
}