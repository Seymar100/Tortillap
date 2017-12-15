package com.example.adminportatil.tortillap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adminportatil on 12/12/2017.
 */

public class MainActivity3 extends AppCompatActivity {
    Button bSiguiente;
    Button bSalir;
    Button bAñadir;
    Button bQuitar;
    RadioGroup rdgTamaño;
    RadioGroup rdgHuevo;
    Spinner sTortillas;
    AlertDialog.Builder alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bSalir = (Button) findViewById(R.id.bSalir);
        bSiguiente = (Button) findViewById(R.id.bSig);
        bAñadir = (Button) findViewById(R.id.bAña);
        bQuitar = (Button) findViewById(R.id.bQui);
        rdgTamaño = (RadioGroup) findViewById(R.id.rdgTam);
        rdgHuevo = (RadioGroup) findViewById(R.id.rdgHuev);
        sTortillas = (Spinner) findViewById(R.id.spinner);

        List<String> listaPedido = Arrays.asList();
        List<String> listaSpinner = Arrays.asList("PATATA", "VERDURA", "BACALAO", "JAMÓN IBÉRICO", "QUESO IDIAZABAL", "HONGOS");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listaSpinner);
        sTortillas.setAdapter(adapter);

        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rdgTamaño.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                if(checkedId==R.id.rdbInd){

                }else if(checkedId==R.id.rdbFam){

                }else {
                    alerta = new AlertDialog.Builder(MainActivity3.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Escoga un TAMAÑO.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            rdgTamaño.requestFocus();
                        }
                    });
                    alerta.show();
                }
            }
        });

        rdgHuevo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                if(checkedId==R.id.rdbGranj){

                }else if(checkedId==R.id.rdbCamp){

                }else if(checkedId==R.id.rdbEco){

                }else {
                    alerta = new AlertDialog.Builder(MainActivity3.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Escoga un TIPO DE HUEVO.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            rdgHuevo.requestFocus();
                        }
                    });
                    alerta.show();
                }
            }
        });
        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
