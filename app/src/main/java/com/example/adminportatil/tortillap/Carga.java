package com.example.adminportatil.tortillap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Esta actividad sera la que haga cargar la pantalla principal de nuestra aplicación.
 */

public class Carga extends Activity {

    //Introduce a delay
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        uiHandler = new Handler();
        uiHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // this will run on the main UI thread
                Intent mainIntent = new Intent(Carga.this, MainActivity.class);
                Carga.this.startActivity(mainIntent);
                Carga.this.finish();
            }
        }, 3000);
    }
}