package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class panelusuario extends AppCompatActivity {

    Button reportar;
    Button confirmar;
    TextView usuarionombre, usuariodni, usuariocodigo, usuariocarrera, usuariosituacion;
    ImageView usuariofoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelusuario);

        reportar = findViewById(R.id.btnreportar);
        confirmar = findViewById(R.id.btnconfirmar);
        usuarionombre = findViewById(R.id.txtusuarionombre);
        usuariodni = findViewById(R.id.txtusuariodni);
        usuariocodigo = findViewById(R.id.txtusuariocodigo);
        usuariocarrera = findViewById(R.id.txtusuariocarrera);
        usuariosituacion = findViewById(R.id.txtusuariosituacion);
        usuariofoto = findViewById(R.id.imusuariofoto);

        // Obtener los datos del intent
        String buscarnumero = getIntent().getStringExtra("numerobuscarusuario");
        String seleccionadaopcion = getIntent().getStringExtra("opcionSeleccionada");
        String qrContent = getIntent().getStringExtra("qrContent");

        // Si la búsqueda es por QR
        if (qrContent != null) {
            handleQrContent(qrContent);
        } else {
            handleSearch(seleccionadaopcion, buscarnumero);
        }

        reportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reporteusuario = new Intent(panelusuario.this, panelreporte.class);
                startActivity(reporteusuario);
            }
        });
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm = new Intent(panelusuario.this, panelregistrar.class);
                startActivity(confirm);
                Toast.makeText(panelusuario.this, "EL USUARIO HA SIDO REGISTRADO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleSearch(String seleccionadaopcion, String buscarnumero) {
        if (seleccionadaopcion != null && buscarnumero != null) {
            if ("Código Universitario".equals(seleccionadaopcion)) {
                switch (buscarnumero) {
                    case "2002010200":
                        setUserDetails("Carlos Eleodoro Romero Cruz", "70602726", "2002010200", "Ingenieria de Sistemas", "Estudiante", R.drawable.juandi);
                        break;
                    case "2002010208":
                        setUserDetails("Gilda Isabel Saavedra Vasquez", "73798883", "2002010208", "Contabilidad", "Egresada", R.drawable.isa);
                        break;
                    case "2002010016":
                        setUserDetails("Juan Diego Avila Carrillo", "72752672", "2002010016", "Ingenieria de Sistemas", "Estudiante", R.drawable.foto1);
                        break;
                    default:
                        Toast.makeText(this, "El estudiante no se encuentra registrado", Toast.LENGTH_SHORT).show();
                        break;
                }
            } else if ("DNI".equals(seleccionadaopcion)) {
                switch (buscarnumero) {
                    case "70602726":
                        setUserDetails("Carlos Eleodoro Romero Cruz", "70602726", "2002010200", "Ingenieria de Sistemas", "Estudiante", R.drawable.juandi);
                        break;
                    case "73798883":
                        setUserDetails("Gilda Isabel Saavedra Vasquez", "73798883", "2002010208", "Contabilidad", "Egresada", R.drawable.isa);
                        break;
                    case "72752672":
                        setUserDetails("Juan Diego Avila Carrillo", "72752672", "2002010016", "Ingenieria de Sistemas", "Estudiante", R.drawable.foto1);
                        break;
                    default:
                        Toast.makeText(this, "El estudiante no se encuentra registrado", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }

    private void handleQrContent(String qrContent) {
        switch (qrContent) {
            case "https://www.70602726":
                setUserDetails("Carlos Eleodoro Romero Cruz", "70602726", "2002010200", "Ingenieria de Sistemas", "Estudiante", R.drawable.juandi);
                break;
            case "https://www.73798883":
                setUserDetails("Gilda Isabel Saavedra Vasquez", "73798883", "2002010208", "Contabilidad", "Egresada", R.drawable.isa);
                break;
            case "https://www.72752672":
                setUserDetails("Juan Diego Avila Carrillo", "72752672", "2002010016", "Ingenieria de Sistemas", "Estudiante", R.drawable.foto1);
                break;
            default:
                Toast.makeText(this, "El estudiante no se encuentra registrado", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void setUserDetails(String nombre, String dni, String codigo, String carrera, String situacion, int fotoResId) {
        usuarionombre.setText(nombre);
        usuariodni.setText(dni);
        usuariocodigo.setText(codigo);
        usuariocarrera.setText(carrera);
        usuariosituacion.setText(situacion);
        usuariofoto.setImageResource(fotoResId);
    }
}
