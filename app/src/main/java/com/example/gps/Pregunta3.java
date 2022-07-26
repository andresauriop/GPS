package com.example.gps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pregunta3 extends AppCompatActivity {

    String pedad;
    String psexo;
    String ptelefono;
    String platitud;
    String plongitud;
    String pregunta1;
    String pregunta2;
    String pregunta3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3);
        Intent intent = getIntent();
        pedad = intent.getStringExtra("edad");
        psexo = intent.getStringExtra("sexo");
        ptelefono = intent.getStringExtra("telefono");
        platitud = intent.getStringExtra("latitud");
        plongitud = intent.getStringExtra("longitud");
        pregunta1 = intent.getStringExtra("pregunta1");
        pregunta2 = intent.getStringExtra("pregunta2");

        Toast.makeText(this,pedad+psexo+ptelefono+platitud+plongitud,Toast.LENGTH_LONG).show();
    }

    public void Siguiente3(View view)
    {
        RadioGroup grupo = findViewById(R.id.opcionespregunta3);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_masculino3) {
            pregunta3 = "S";}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_femenino3) {
            pregunta3 = "N";}

        Intent intent = new Intent(this, Resultados.class);
        intent.putExtra("edad",pedad);
        intent.putExtra("sexo",psexo);
        intent.putExtra("telefono",ptelefono);
        intent.putExtra("latitud",platitud);
        intent.putExtra("longitud",plongitud);
        intent.putExtra("pregunta1",pregunta1);
        intent.putExtra("pregunta2",pregunta2);
        intent.putExtra("pregunta3",pregunta3);
        startActivity(intent);
    }
}