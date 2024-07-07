package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class panelchofer extends AppCompatActivity {

    Spinner choferes,recorridos;
    Button cambiarchofer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelchofer);

        choferes = findViewById(R.id.spcambiochofer);
        recorridos = findViewById(R.id.spcambioruta);
        cambiarchofer = findViewById(R.id.btncambiarchofer);

        String[] opciones = {"Juan Diego Avila Carrillo", "Hans Ascensio Molleda","Diego Enrique Gerónimo Silvestre","Carlos Eleodoro Romero Cruz"};
        ArrayAdapter<String> opcionesspiner= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        opcionesspiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choferes.setAdapter(opcionesspiner);

        String[] opciones2 = {"Chincha/Universidad", "Quilmaná/Universidad","Lunahuaná/Universidad","Mala/Universidad"};
        ArrayAdapter<String> opcionesspiner2= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones2);
        opcionesspiner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recorridos.setAdapter(opcionesspiner2);

        //mostrar la eleccion
        choferes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                String opcionSeleccionada = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelchofer.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });//fin de mostrar la eleccion

        //mostrar la eleccion
        recorridos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                String opcionSeleccionada = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelchofer.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });//fin de mostrar la eleccion
    }
}