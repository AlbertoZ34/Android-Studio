package com.example.sdist.calculadoramaizoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText opera1, opera2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opera1=(EditText)findViewById(R.id.editText);
        opera2=(EditText)findViewById(R.id.editText2);
    }

    public void suma(View v){
        int num1,num2,res;
        num1=Integer.parseInt(opera1.getText().toString());
        num2=Integer.parseInt(opera2.getText().toString());

        res=num1+num2;
        mostrar(res);

    }

    public void mostrar(int res){
        Toast.makeText(this, "El Resultado es: "+res, Toast.LENGTH_LONG).show();

    }

    public void mostrarD(double res){
        Toast.makeText(this, "El Resultado es: "+res, Toast.LENGTH_LONG).show();

    }

    public void resta(View v){
        int num1,num2,res;
        num1=Integer.parseInt(opera1.getText().toString());
        num2=Integer.parseInt(opera2.getText().toString());

        res=num1-num2;
        mostrar(res);
    }

    public void Mult(View v){
        int num1,num2,res;
        num1=Integer.parseInt(opera1.getText().toString());
        num2=Integer.parseInt(opera2.getText().toString());

        res=num1*num2;
        mostrar(res);

    }

    public void division(View v){
        double num1,num2,res;
        num1=Double.parseDouble(opera1.getText().toString());
        num2=Double.parseDouble(opera2.getText().toString());

        res=num1/num2;
        mostrarD(res);

    }

    public void cuad(View v){
        int num1,num2,res;
        num1=Integer.parseInt(opera1.getText().toString());
        num2=Integer.parseInt(opera2.getText().toString());

        res=num1;
        mostrar(res);

    }

    public void cub(View v){
        int num1,num2,res;
        num1=Integer.parseInt(opera1.getText().toString());
        num2=Integer.parseInt(opera2.getText().toString());

        res=num1;
        mostrar(res);

    }



}
