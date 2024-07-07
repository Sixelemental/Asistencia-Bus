package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class panelverreporte extends AppCompatActivity {

    TableLayout tablareportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelverreporte);

        tablareportes = findViewById(R.id.tbreportes);

        TableRow headerRow3 = new TableRow(this); //para crear encabezados

        TextView header1 = new TextView(this);
        header1.setText("N°");
        header1.setPadding(16, 16, 16, 16);
        header1.setBackgroundColor(Color.GREEN);
        header1.setTextColor(Color.BLACK);
        headerRow3.addView(header1);

        TextView header2 = new TextView(this);
        header2.setText("DELEGADO");
        header2.setPadding(16, 16, 16, 16);
        header2.setBackgroundColor(Color.GREEN);
        header2.setTextColor(Color.BLACK);
        headerRow3.addView(header2);

        TextView header3 = new TextView(this);
        header3.setText("USUARIO");
        header3.setPadding(16, 16, 16, 16);
        header3.setBackgroundColor(Color.GREEN);
        header3.setTextColor(Color.BLACK);
        headerRow3.addView(header3);

        TextView header4 = new TextView(this);
        header4.setText("DETALLE");
        header4.setPadding(16, 16, 16, 16);
        header4.setBackgroundColor(Color.GREEN);
        header4.setTextColor(Color.BLACK);
        headerRow3.addView(header4);

        tablareportes.addView(headerRow3);

        int filas = 5; // este numero cambiará según el SQL
        for (int i = 0; i < filas; i++) {
            TableRow tablefilas = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(String.valueOf(i + 1)); // aquí se enlaza con el número de filas, esto lo puedo hacer con SQL
            textView1.setPadding(16, 16, 16, 16);
            textView1.setTextColor(Color.BLACK);
            tablefilas.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText("JUAN DIEGO AVILA CARRILLO"); // aquí se ingresa el NOMBRE DE cada DELEGADO QUE REPORTA del SQL
            textView2.setPadding(16, 16, 16, 16);
            textView2.setTextColor(Color.BLACK);
            tablefilas.addView(textView2);

            TextView textView3 = new TextView(this);
            textView3.setText("CARLOS ELEODORO ROMERO CRUZ"); // aquí se ingresa el NOMBRE DEL REPORTADO
            textView3.setPadding(16, 16, 16, 16);
            textView3.setTextColor(Color.BLACK);
            tablefilas.addView(textView3);

            TextView textView4 = new TextView(this);
            textView4.setText("Llevó bebidas alcohólicas"); // aquí se ingresa el DETALLE DEL REPORTE de cada modo del SQL
            textView4.setPadding(16, 16, 16, 16);
            textView4.setTextColor(Color.BLACK);
            tablefilas.addView(textView4);

            tablareportes.addView(tablefilas);
        } // fin de for
    }
}
