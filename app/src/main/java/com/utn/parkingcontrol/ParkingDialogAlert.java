package com.utn.parkingcontrol;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParkingDialogAlert  {

    public static AlertDialog CreateAlertDialog(Context context, LayoutInflater inflater, ViewGroup container, Bundle save) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = inflater.inflate(R.layout.register_parking, null);
        View view2 = inflater.inflate(R.layout.activity_main_menu, null);


        TextView tvUserName2 = (TextView) view2.findViewById(R.id.txtNameUserHome);
        String userName = tvUserName2.getText().toString();

        EditText et_Matricula = (EditText) view.findViewById(R.id.txtNroMatricula);
        EditText et_Tiempo = (EditText) view.findViewById(R.id.txtTiempo);
        Button cancelar = view.findViewById(R.id.btnCancelar);
        Button registrar = view.findViewById(R.id.btnRegistrar);

        TextView tvUserName = (TextView) view.findViewById(R.id.txtUserName);
        tvUserName.setText(userName);
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
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(v.getContext(), "administracion", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();

                String matricula = et_Matricula.getText().toString();
                String tiempo = et_Tiempo.getText().toString();



                if (!matricula.isEmpty() && !tiempo.isEmpty()) {
                    ContentValues registro = new ContentValues();
                    registro.put("matricula", matricula);
                    registro.put("tiempo", tiempo);
                    registro.put("userName", userName);

                    db.insert("parkings", null, registro);

                    Toast.makeText(v.getContext(), "Datos guardados", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(v.getContext(), "Debes llenar Matricula y Tiempo", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });

        return alertDialog;
    }

}
