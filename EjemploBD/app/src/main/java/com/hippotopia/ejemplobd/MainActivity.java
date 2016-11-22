package com.hippotopia.ejemplobd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3, et4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.etClaveU);
        et2=(EditText)findViewById(R.id.etNombre);
        et3=(EditText)findViewById(R.id.etCarrera);
        et4=(EditText)findViewById(R.id.etUniversidad);

    }


    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cu = et1.getText().toString();
        String nom = et2.getText().toString();
        String carr = et3.getText().toString();
        String uni = et4.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("cu",cu);
        registro.put("nombre",nom);
        registro.put("carrera",carr);
        registro.put("universidad",uni);

        db.insert("alumnos",null,registro);
        db.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        Toast.makeText(this, "Se cargaron los datos adecuadamente", Toast.LENGTH_LONG).show();
    }

    public void consulta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cu = et1.getText().toString();
        Cursor file =db.rawQuery( //devuelve 0 o 1 fila // es una consulta
                "select nombre, carrera,"+" universidad from alumnos where cu="+cu,null);
        if(file.moveToFirst()){ // si ha devuelto 1 fila, vamos  al primero (que es el unico)
            et2.setText(file.getString(0));
            et3.setText(file.getString(1));
            et4.setText(file.getString(2));
        }else
            Toast.makeText(this,"No exite una persona con dicho cu",Toast.LENGTH_LONG).show();
        db.close();

    }

    public void limpia(View v){
        //AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        //SQLiteDatabase db = admin.getWritableDatabase();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Se han borrado los datos", Toast.LENGTH_LONG).show();
    }

    public void baja(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cu=et1.getText().toString();
        int cant = db.delete("alumnos","cu="+cu,null);
        db.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        if(cant==1)
            Toast.makeText(this,"se borró el alumno",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"No se borro el alumno",Toast.LENGTH_LONG).show();

    }

    public void modifica(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cu = et1.getText().toString();
        String nom = et2.getText().toString();
        String carr = et3.getText().toString();
        String uni = et4.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("cu",cu);
        registro.put("nombre",nom);
        registro.put("carrera",carr);
        registro.put("universidad",uni);

        db.update("alumnos",registro,"cu="+cu,null);
        db.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        Toast.makeText(this, "Se Modificaron los datos adecuadamente", Toast.LENGTH_LONG).show();

    }


}
