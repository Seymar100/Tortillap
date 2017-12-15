package com.example.adminportatil.tortillap;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by adminportatil on 12/12/2017.
 */

public class MainActivity2 extends AppCompatActivity {
    Button bSiguiente;
    Button bSalir;
    EditText etNombre;
    EditText etDireccion;
    EditText etEmail;
    EditText etNumero;
    AlertDialog.Builder alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bSalir = (Button) findViewById(R.id.bSalir);
        bSiguiente = (Button) findViewById(R.id.bSig);
        etNombre = (EditText) findViewById(R.id.etNom);
        etDireccion = (EditText) findViewById(R.id.etDir);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etNumero = (EditText) findViewById(R.id.etNum);



        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNombre.length() == 0) {
                    alerta = new AlertDialog.Builder(MainActivity2.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Se requiere Nombre.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            etNombre.requestFocus();
                        }
                    });
                    alerta.show();
                } else if (etDireccion.length() == 0) {
                    alerta = new AlertDialog.Builder(MainActivity2.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Se requiere Direccion.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            etDireccion.requestFocus();
                        }
                    });
                    alerta.show();
                } else if(etEmail.length() == 0 || isValidEmailAddress(etEmail.getText().toString())==false) {
                    alerta = new AlertDialog.Builder(MainActivity2.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Se requiere Email valido.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            etEmail.requestFocus();
                        }
                    });
                    alerta.show();
                }else if (etNumero.length() == 0) {
                    alerta = new AlertDialog.Builder(MainActivity2.this);
                    alerta.setTitle("Problemitass");
                    alerta.setMessage("Se requiere Número de móvil.");
                    alerta.setCancelable(false);
                    alerta.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            etNumero.requestFocus();
                        }
                    });
                    alerta.show();
                } else {

                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("Nombre", etNombre.getText().toString());
                    intent.putExtra("Direccion", etDireccion.getText().toString());
                    intent.putExtra("Email", etEmail.getText().toString());
                    intent.putExtra("Numero", etNumero.getText().toString());

                    startActivityForResult(intent, 123);


                }
            }
        });
    }
    public static boolean isValidEmailAddress(String email) {
        boolean result;
        if(!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z]{2,})$"))
            result=false;
        else result=true;

        return result;
    }

}


