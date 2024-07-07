package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.graphics.Color;

public class panelasistencia extends AppCompatActivity {

    String codigousuario;
    TableLayout asistenciapersonal;
    TextView asistencianombre, asistenciacodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelasistencia);

        asistenciapersonal = findViewById(R.id.tbasistenciapersonal);
        asistencianombre = findViewById(R.id.txtnombreasistencia);
        codigousuario = getIntent().getStringExtra("nombreusuario");
        asistenciacodigo = findViewById(R.id.txtcodusuario);

        asistenciacodigo.setText(codigousuario);
        asistenciacodigo.setTextColor(Color.BLACK);

        //para agregar las filas y columnas
        TableRow headerRow = new TableRow(this); //para crear encabezados

        TextView header1 = new TextView(this);
        header1.setText("N°");
        header1.setPadding(16, 16, 16, 16);
        header1.setBackgroundColor(Color.GREEN);
        header1.setTextColor(Color.BLACK);
        headerRow.addView(header1);

        TextView header2 = new TextView(this);
        header2.setText("RUTA");
        header2.setPadding(16, 16, 16, 16);
        header2.setBackgroundColor(Color.GREEN);
        header2.setTextColor(Color.BLACK);
        headerRow.addView(header2);

        TextView header3 = new TextView(this);
        header3.setText("FECHA");
        header3.setPadding(16, 16, 16, 16);
        header3.setBackgroundColor(Color.GREEN);
        header3.setTextColor(Color.BLACK);
        headerRow.addView(header3);

        TextView header4 = new TextView(this);
        header4.setText("MODO");
        header4.setPadding(16, 16, 16, 16);
        header4.setBackgroundColor(Color.GREEN);
        header4.setTextColor(Color.BLACK);
        headerRow.addView(header4);

        TextView header5 = new TextView(this);
        header5.setText("TURNO");
        header5.setPadding(16, 16, 16, 16);
        header5.setBackgroundColor(Color.GREEN);
        header5.setTextColor(Color.BLACK);
        headerRow.addView(header5);

        asistenciapersonal.addView(headerRow);

        int filas = 5; // este numero cambiará según el SQL
        for (int i = 0; i < filas; i++) {
            TableRow tablefilas = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(String.valueOf(i + 1)); // aqui se enlaza con el numero de filas, esto lo puedo hacer con SQL
            textView1.setPadding(16, 16, 16, 16);
            textView1.setTextColor(Color.BLACK);
            tablefilas.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText("Chincha-universidad"); // aqui se ingresa el contenido de cada viaje del SQL
            textView2.setPadding(16, 16, 16, 16);
            textView2.setTextColor(Color.BLACK);
            tablefilas.addView(textView2);

            TextView textView3 = new TextView(this);
            textView3.setText("27-06-2024"); // aqui se ingresa el contenido de cada fecha del SQL
            textView3.setPadding(16, 16, 16, 16);
            textView3.setTextColor(Color.BLACK);
            tablefilas.addView(textView3);

            TextView textView4 = new TextView(this);
            textView4.setText("ida"); // aqui se ingresa el contenido de cada modo del SQL
            textView4.setPadding(16, 16, 16, 16);
            textView4.setTextColor(Color.BLACK);
            tablefilas.addView(textView4);

            TextView textView5 = new TextView(this);
            textView5.setText("mañana"); // aqui se ingresa el contenido de cada turno del SQL
            textView5.setPadding(16, 16, 16, 16);
            textView5.setTextColor(Color.BLACK);
            tablefilas.addView(textView5);

            asistenciapersonal.addView(tablefilas);
        } // fin de for
    }
}
