package com.example.app7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class panelagregarusuario extends AppCompatActivity {

    private static final int REQUEST_CODE_SELECT_PHOTO = 1;
    private static final int REQUEST_CODE_SELECT_EXCEL = 2;
    private static final int REQUEST_CODE_PERMISSIONS = 3;

    private ImageButton fotonuevo;
    EditText nuevonombre,nuevodni,nuevocodigo;
    Spinner nuevacarrera,nuevasituacion;
    Button agregarnuevo, subirexcel, bajarexcel;
    TextView mostrarnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panelagregarusuario);

        fotonuevo = findViewById(R.id.ibfoto);
        nuevonombre = findViewById(R.id.etnombresnuevos);
        nuevodni = findViewById(R.id.etdninuevo);
        nuevocodigo = findViewById(R.id.etcodigonuevo);
        nuevacarrera = findViewById(R.id.spagregarcarrera);
        nuevasituacion = findViewById(R.id.spagregarsituacion);
        agregarnuevo = findViewById(R.id.btnagregarusuarionuevo);
        subirexcel = findViewById(R.id.btnsubirexcel);
        bajarexcel = findViewById(R.id.btndescargarexcel);
        mostrarnombre = findViewById(R.id.txtnombreexcel);

        fotonuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionsAndOpenGallery();
            }
        });

        subirexcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionsAndOpenFilePicker();
            }
        });

        bajarexcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadExcelFile();
            }
        });

        String[] opcionescarrera = {"Ingenieria de sistemas", "Turismo y hotelería","Contabilidad","Agronomía","Administración de empresas","Docente/administrativo"};
        ArrayAdapter<String> opcionesspiner= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionescarrera);
        opcionesspiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nuevacarrera.setAdapter(opcionesspiner);

        nuevacarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                String opcionSeleccionada = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelagregarusuario.this, "Seleccionaste: " + opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });//fin de mostrar la eleccion

        String[] opcionessituacion = {"Estudiante", "Ingresante","Egresado","Docente","Administrativo","Chofer"};
        ArrayAdapter<String> opcionesspiner2= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionessituacion);
        opcionesspiner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nuevasituacion.setAdapter(opcionesspiner2);

        nuevasituacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtiene la opción seleccionada
                String opcionSeleccionada2 = parent.getItemAtPosition(position).toString();
                // Realiza alguna acción según la opción seleccionada
                Toast.makeText(panelagregarusuario.this, "Seleccionaste: " + opcionSeleccionada2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Método requerido, pero no lo estamos utilizando en este ejemplo
            }
        });//fin de mostrar la eleccion
    }

    private void checkPermissionsAndOpenGallery() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSIONS);
        } else {
            openGallery();
        }
    }

    private void checkPermissionsAndOpenFilePicker() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSIONS);
        } else {
            openFilePicker();
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE_SELECT_PHOTO);
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        startActivityForResult(intent, REQUEST_CODE_SELECT_EXCEL);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else if (requestCode == REQUEST_CODE_SELECT_EXCEL) {
                openFilePicker();
            } else {
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT_PHOTO && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                fotonuevo.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == REQUEST_CODE_SELECT_EXCEL && resultCode == RESULT_OK && data != null) {
            Uri selectedExcelUri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(selectedExcelUri);
                File outFile = new File(getFilesDir(), "uploaded_file.xlsx");
                OutputStream outputStream = new FileOutputStream(outFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                outputStream.close();
                inputStream.close();
                mostrarnombre.setText(outFile.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void downloadExcelFile() {
        try {
            InputStream inputStream = getAssets().open("excelbus.xlsx"); // Reemplazado aquí
            File outFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "excelbus.xlsx"); // Reemplazado aquí también
            OutputStream outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
            Toast.makeText(this, "Archivo descargado en: " + outFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}