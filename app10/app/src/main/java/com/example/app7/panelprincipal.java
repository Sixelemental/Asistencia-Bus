package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class panelprincipal extends AppCompatActivity {

    String enlacerutas, delegado;
    Button rutas, asistencia, registro;
    TextView tipo, nombres, dni, codigo, carrera, situacion;
    ImageView foto, qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelprincipal);

        enlacerutas = "https://drive.google.com/file/d/1dEEMWSZmuukHd0mw2755JQfFq4IRbGuk/view?fbclid=IwAR2rayHhZbczbo4tDBe8jqO2AKznSh0v9Bv5tmQU1YrfasVQn5YA1EmK9Tk_aem_AYOG0_bV9wA-Fxnpbv-ja2D3ENPM7gGDE55OheZg4KeKKTasCUdtpeJuiyyVEuS7n1b2lum-alRBmuY3-EO_65BJ";

        rutas = findViewById(R.id.btnrutas);
        asistencia = findViewById(R.id.btnasistencia);
        registro = findViewById(R.id.btnregistrar);
        delegado = getIntent().getStringExtra("delegado");

        tipo = findViewById(R.id.txttipousuario);
        nombres = findViewById(R.id.txtnombre);
        dni = findViewById(R.id.txtdni);
        codigo = findViewById(R.id.txtcodigo);
        carrera = findViewById(R.id.txtcarrera);
        situacion = findViewById(R.id.txtsituacion);
        foto = findViewById(R.id.imgfoto);
        qr = findViewById(R.id.imgqr);

        rutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriruta = Uri.parse(enlacerutas);
                Intent rutabus = new Intent(Intent.ACTION_VIEW, uriruta);
                startActivity(rutabus);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarviaje = new Intent(panelprincipal.this, panelviaje.class);
                startActivity(registrarviaje);
            }
        });

        actualizarDatosUsuario(delegado);

        asistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irasistencia = new Intent(panelprincipal.this, panelasistencia.class);
                irasistencia.putExtra("nombreusuario",delegado);
                startActivity(irasistencia);
            }
        });
    }

    private void actualizarDatosUsuario(String delegado) {
        if (delegado != null) {
            switch (delegado) {
                case "2002010200":
                    nombres.setText("Carlos Eleodoro Romero Cruz");
                    dni.setText("70602726");
                    codigo.setText("2002010200");
                    carrera.setText("Ing. de sistemas");
                    situacion.setText("Estudiante");
                    foto.setImageResource(R.drawable.juandi);
                    tipo.setText("ORDINARIO");
                    registro.setVisibility(View.GONE);
                    qr.setImageResource(R.drawable.qr70602726);
                    break;
                case "2002010016":
                    nombres.setText("Juan Diego Avila Carrillo");
                    dni.setText("72752672");
                    codigo.setText("2002010016");
                    carrera.setText("Contabilidad");
                    situacion.setText("Estudiante");
                    foto.setImageResource(R.drawable.foto1);
                    tipo.setText("DELEGADO");
                    registro.setVisibility(View.VISIBLE);
                    qr.setImageResource(R.drawable.qr72752672);
                    break;
                case "2002010208":
                    nombres.setText("Gilda Isabel Saavedra Vasquez");
                    dni.setText("73798883");
                    codigo.setText("2002010208");
                    carrera.setText("Ing. de sistemas");
                    situacion.setText("Egresada");
                    foto.setImageResource(R.drawable.isa);
                    tipo.setText("ADMINISTRADOR");
                    registro.setVisibility(View.VISIBLE);
                    qr.setImageResource(R.drawable.qr73798883);
                    break;
                default:
                    Toast.makeText(this, "Necesita ingresar un usuario y contraseña", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            Toast.makeText(this, "Necesita ingresar un usuario y contraseña", Toast.LENGTH_SHORT).show();
        }
    }
}

