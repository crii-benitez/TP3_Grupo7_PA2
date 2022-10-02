package com.utn.parkingcontrol;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParkingDialogAlert  {

    public static AlertDialog CreateAlertDialog(Context context, LayoutInflater inflater,User user) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = inflater.inflate(R.layout.register_parking, null);

        TextView tvUserName = (TextView) view.findViewById(R.id.txtUserName);
        EditText et_Matricula = (EditText) view.findViewById(R.id.txtNroMatricula);
        EditText et_Tiempo = (EditText) view.findViewById(R.id.txtTiempo);
        Button cancelar = view.findViewById(R.id.btnCancelar);
        Button registrar = view.findViewById(R.id.btnRegistrar);
        tvUserName.setText(user.getName());

        builder.setView(view);

        AlertDialog alertDialog = builder.create();

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();

                String matricula = et_Matricula.getText().toString();
                String tiempo = et_Tiempo.getText().toString();

                if (!matricula.isEmpty() && !tiempo.isEmpty()) {
                    ContentValues registro = new ContentValues();
                    registro.put("name", matricula);
                    registro.put("email", tiempo);
                    registro.put("pass", user.getName());

                    try{
                        db.insert("users2", null, registro);

                        Toast.makeText(v.getContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                    catch (Exception e) {
                        Toast.makeText(v.getContext(), "error:" + e , Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(context, "Debes llenar Matricula y Tiempo", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        return alertDialog;
    }

}
