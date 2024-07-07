package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contraseña;
    Button ingresar;
    int n = 0; // n es el contador de errores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.edittextusuario);
        contraseña = findViewById(R.id.edittextcontrasena);
        ingresar = findViewById(R.id.btningresar);

        //para ingresar al boton
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obteniendo los valores de los edittext
                String usuarioText = usuario.getText().toString().trim();
                String contraseñaText = contraseña.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                if (usuarioText.equals("2002010200") && contraseñaText.equals("70602726")) {
                    editor.putString("delegado", usuarioText);
                    editor.apply();
                    Intent principal1 = new Intent(MainActivity.this, panelprincipal.class);
                    principal1.putExtra("delegado",usuarioText);
                    startActivity(principal1);
                } else if (usuarioText.equals("2002010016") && contraseñaText.equals("72752672")) {
                    editor.putString("delegado", usuarioText);
                    editor.apply();
                    Intent principal2 = new Intent(MainActivity.this, panelprincipal.class);
                    principal2.putExtra("delegado",usuarioText);
                    startActivity(principal2);
                } else if (usuarioText.equals("2002010208") && contraseñaText.equals("73798883")) {
                    editor.putString("delegado", usuarioText);
                    editor.apply();
                    Intent principal3 = new Intent(MainActivity.this, panelprincipal.class);
                    principal3.putExtra("delegado",usuarioText);
                    startActivity(principal3);
                } else {
                    n = n + 1;
                    if (n == 1) {
                        mensajeerror();
                    } else {
                        mensajealerta();
                    }
                }
            }
        });
    }

    //creando la funcion del botón error
    private void mensajeerror() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("El usuario/contraseña están incorrecto, volver a intentar")
                .setTitle("Error de ingreso")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //creando la funcion del botón alerta
    private void mensajealerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Los datos ingresados están incorrectos, por favor asistir a la oficina de la universidad y consultar sus datos.")
                .setTitle("Alerta de ingreso")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
