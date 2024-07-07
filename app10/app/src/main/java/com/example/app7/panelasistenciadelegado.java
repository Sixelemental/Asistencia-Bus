package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class panelasistenciadelegado extends AppCompatActivity {

    TableLayout asistenciadelegado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelasistenciadelegado);

        asistenciadelegado = findViewById(R.id.tbasistenciadelegado);

        //para agregar las filas y columnas
        TableRow headerRow2 = new TableRow(this); //para crear encabezados

        TextView header1 = new TextView(this);
        header1.setText("N°");
        header1.setPadding(16, 16, 16, 16);
        header1.setBackgroundColor(Color.GREEN);
        header1.setTextColor(Color.BLACK);
        headerRow2.addView(header1);

        TextView header2 = new TextView(this);
        header2.setText("NOMBRES Y APELLIDOS");
        header2.setPadding(16, 16, 16, 16);
        header2.setBackgroundColor(Color.GREEN);
        header2.setTextColor(Color.BLACK);
        headerRow2.addView(header2);

        TextView header3 = new TextView(this);
        header3.setText("SITUACION");
        header3.setPadding(16, 16, 16, 16);
        header3.setBackgroundColor(Color.GREEN);
        header3.setTextColor(Color.BLACK);
        headerRow2.addView(header3);

        asistenciadelegado.addView(headerRow2);

        int filas = 5;//este numero cambiará segun el SQL
        for (int i = 0; i < filas; i++) {
            TableRow tablefilas2 = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(String.valueOf(i + 1));//aqui se enlaza con el numero de filas, esto lo puedo hacer con SQL
            textView1.setPadding(16, 16, 16, 16);
            textView1.setTextColor(Color.BLACK);
            tablefilas2.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText("Carlos Eleodoro Romero Cruz");//aqui se ingresa el contenido de cada viaje del sql
            textView2.setPadding(16, 16, 16, 16);
            textView2.setTextColor(Color.BLACK);
            tablefilas2.addView(textView2);

            TextView textView3 = new TextView(this);
            textView3.setText("Estudiante");//aqui se ingresa el contenido de cada viaje del sql
            textView3.setPadding(16, 16, 16, 16);
            textView3.setTextColor(Color.BLACK);
            tablefilas2.addView(textView3);

            asistenciadelegado.addView(tablefilas2);
        }//fin de for
    }
}
