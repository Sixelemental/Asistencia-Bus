package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class panelreporte extends AppCompatActivity {

    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelreporte);

        enviar = (Button) findViewById(R.id.btnenviarreporte);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(panelreporte.this, "El usuario ha sido reportado", Toast.LENGTH_SHORT).show();
                Intent enviarreporte = new Intent(panelreporte.this,panelregistrar.class);
                startActivity(enviarreporte);
            }
        });

    }
}