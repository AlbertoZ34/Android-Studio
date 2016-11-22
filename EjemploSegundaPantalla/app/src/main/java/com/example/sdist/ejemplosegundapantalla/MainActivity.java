package com.example.sdist.ejemplosegundapantalla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNom;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener la referencia de los controles de la interfaz
        txtNom=(EditText)findViewById(R.id.editText);
        btnAceptar=(Button)findViewById(R.id.button);
    }

    //En andriodtodo lo que se hace entre clases para comunicarse se llama intent

    public void aceptar(View v){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        Bundle b = new Bundle(); // me permite guardar el nombre, como la session
        b.putString("Nombre",txtNom.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }

}
