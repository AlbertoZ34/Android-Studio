package com.example.sdist.ejercicioextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nom,edad;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=(EditText)findViewById(R.id.editTextN);
        edad=(EditText)findViewById(R.id.editTextE);
    }

    public void entrar(View v){
        Intent intent= new Intent(MainActivity.this,Main2Activity.class);


    }

}
