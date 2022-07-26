package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Pregunta1 extends AppCompatActivity {

    String pedad;
    String psexo;
    String ptelefono;
    String platitud;
    String plongitud;
    String pregunta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        Intent intent = getIntent();
        pedad = intent.getStringExtra("edad");
        psexo = intent.getStringExtra("sexo");
        ptelefono = intent.getStringExtra("telefono");
        platitud = intent.getStringExtra("latitud");
        plongitud = intent.getStringExtra("longitud");

        Toast.makeText(this,platitud+" " +plongitud,Toast.LENGTH_LONG).show();
    }

    public void Siguiente(View view)
    {
        RadioGroup grupo = findViewById(R.id.opcionespregunta);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_masculino) {
            pregunta1 = "S";}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_femenino) {
            pregunta1 = "N";}

        Intent intent = new Intent(this,Pregunta2.class);
        intent.putExtra("edad",pedad);
        intent.putExtra("sexo",psexo);
        intent.putExtra("telefono",ptelefono);
        intent.putExtra("latitud",platitud);
        intent.putExtra("longitud",plongitud);
        intent.putExtra("pregunta1",pregunta1);
        startActivity(intent);
    }
}