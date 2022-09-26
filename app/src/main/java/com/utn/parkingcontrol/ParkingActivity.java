package com.utn.parkingcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import java.util.ArrayList;

public class ParkingActivity extends AppCompatActivity {

    GridView gvParking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_parking);

        gvParking = findViewById(R.id.gvParking);

        SetParking(GetParkingBD());
    }

    private void SetParking(ArrayList<Parking> parkingList)
    {
        ParkingAdapter parkingAdapter = new ParkingAdapter(this, parkingList);
        gvParking.setAdapter(parkingAdapter);
    }

    private ArrayList<Parking> GetParkingBD()
    {
        ArrayList<Parking> parkingList = new ArrayList<>();

        // TODO: Setear el list con los datos de la BD.
        parkingList.add(new Parking(1, "ABC-332", "84122184"));
        parkingList.add(new Parking(2, "BRF-121", "23144412"));
        parkingList.add(new Parking(3, "PVC-552", "51244442"));

        return parkingList;
    }
}