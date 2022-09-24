package com.utn.parkingcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_email,et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void RegisterActivity (View view) {
        setContentView(R.layout.register_user);
    }
    public void Registrar (View view) {
        et_name = (EditText)findViewById(R.id.editTextName);
        et_email = (EditText)findViewById(R.id.editTextEmail);
        et_pass = (EditText)findViewById(R.id.editTextPass);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_pass.getText().toString();

        if (!name.isEmpty()&&!email.isEmpty()&&!pass.isEmpty())
            {
                ContentValues registro = new ContentValues();
                registro.put("name",name);
                 registro.put("email",email);
                 registro.put("pass",pass);

                 db.insert("users", null ,registro);
           db.close();
                 Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
                   et_name.setText("");
                   et_email.setText("");
            et_pass.setText("");
               }
            else{
            Toast.makeText(this, "Debes llenar todos lo campos", Toast.LENGTH_SHORT).show();
            }

    }





}