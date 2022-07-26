package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {
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
        setContentView(R.layout.activity_resultados);
        Intent intent = getIntent();
        TextView txtedad = findViewById(R.id.lblEdad);
        TextView txtsexo = findViewById(R.id.lblSexo);
        TextView txttelefono = findViewById(R.id.lblTelefono);
        TextView txtlatitud = findViewById(R.id.lblLat);
        TextView txtlongitud = findViewById(R.id.lblLong);
        TextView txtp1 = findViewById(R.id.lblP1);
        TextView txtp2 = findViewById(R.id.lblP2);
        TextView txtp3 = findViewById(R.id.lblP3);

        pedad = intent.getStringExtra("edad");
        psexo = intent.getStringExtra("sexo");
        ptelefono = intent.getStringExtra("telefono");
        platitud = intent.getStringExtra("latitud");
        plongitud = intent.getStringExtra("longitud");
        pregunta1 = intent.getStringExtra("pregunta1");
        pregunta2 = intent.getStringExtra("pregunta2");
        pregunta3 = intent.getStringExtra("pregunta3");

        txtedad.setText(pedad);
        txtsexo.setText(psexo);
        txttelefono.setText(ptelefono);
        txtlatitud.setText(platitud);
        txtlongitud.setText(plongitud);
        txtp1.setText(pregunta1);
        txtp2.setText(pregunta2);
        txtp3.setText(pregunta3);





    }
}