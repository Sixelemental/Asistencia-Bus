package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.journeyapps.barcodescanner.CaptureActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class panelqr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelqr);

        // Inicia el escaneo del código QR
        startQRScanner();

    }

    //codigo de funcionamiento del scaneer
    private void startQRScanner() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(true); // Permitir rotación
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Escanea un código QR");
        integrator.setCameraId(0); // Usa la cámara trasera
        integrator.setCaptureActivity(CaptureActivity.class);
        integrator.initiateScan();
    }

    //PERMITIR LA LECTURA DEL QR
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents()== null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show();
            } else {
                // Aquí puedes manejar la información obtenida del QR
                String qrContent = result.getContents();
                Toast.makeText(this, "Escaneado: " + qrContent, Toast.LENGTH_LONG).show();

                // Verifica el contenido del QR y navega al panel adecuado
                Intent intent = new Intent(this, panelusuario.class);
                intent.putExtra("qrContent", qrContent);
                startActivity(intent);
            }
            finish(); // Cerrar la actividad después del escaneo
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}//fin del proyecto