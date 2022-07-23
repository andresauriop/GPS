package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_FINE_LOCATION = 2;
    final long LOCATION_REFRESH_TIME = 5000;
    final float LOCATION_REFRESH_DISTANCE = 5;
    LocationManager mLocationManager = null;

    private final LocationListener mLocationListener = new
            LocationListener() {
                @Override
                public void onLocationChanged(final Location location) {
                    String coordenadas = "Lat:" +
                            String.valueOf(location.getLatitude()) + " Long:" +
                            String.valueOf(location.getLongitude());
                    Log.d("gps", coordenadas);
                    TextView txtubicacion = findViewById(R.id.coordenadas);
                    txtubicacion.setText(coordenadas);
                    txtubicacion.setTextColor(Color.BLACK);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                @Override
                public void onProviderEnabled(String provider) {
                }

                @Override
                public void onProviderDisabled(String provider) {
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final AlertDialog.Builder dialogopermisos = null;
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final AlertDialog.Builder dialogopermisos1 = new AlertDialog.Builder(this);

        if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            dialogopermisos1.setTitle("Se requieren permisos para obtener localización precisa");
            dialogopermisos1.setMessage("Por favor ingrese los permisos");
            dialogopermisos1.setPositiveButton(android.R.string.ok, null);
            dialogopermisos1.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_FINE_LOCATION);
                }
            });
            dialogopermisos.show();
        }

        if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "No se tienen los permisos.  Reinicie la aplicación", Toast.LENGTH_SHORT).show();
//            TextView txtmsg = findViewById(R.id.defecto);
//            txtmsg.setText("Reiniciar aplicacion");
        } else {
            //mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, mLocationListener);
        }
    }

    public void recuperarcoordenadas(View view) {
        if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            {
                Location inicial = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (inicial != null) {
                    //String coordenadas = "String.valueOf(Math.round(inicial.getLatitude()*100/100)) + "Long:" + String.valueOf(inicial.getLongitude());
                    String latitud = String.format("%.2f", inicial.getLatitude());
                    String longitud = String.format("%.2f", inicial.getLongitude());
                    String coordenadas = latitud + " "+longitud;
                    Log.d("gps.click", coordenadas);
                    TextView txtubicacion = findViewById(R.id.coordenadas);
                    txtubicacion.setText(coordenadas);
                }
            }
        }
        RadioGroup grupo = findViewById(R.id.opciones_sexo);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_masculino) {
            Toast.makeText(this, "Masculino", Toast.LENGTH_LONG).show();}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_femenino) {
                Toast.makeText(this, "Feminino", Toast.LENGTH_LONG).show();}
    }
}