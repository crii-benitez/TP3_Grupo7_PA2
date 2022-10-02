package com.utn.parkingcontrol.ui.parking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.utn.parkingcontrol.AdminSQLiteOpenHelper;
import com.utn.parkingcontrol.Parking;
import com.utn.parkingcontrol.ParkingAdapter;
import com.utn.parkingcontrol.ParkingDialogAlert;
import com.utn.parkingcontrol.PutExtraConst;
import com.utn.parkingcontrol.R;
import com.utn.parkingcontrol.User;
import com.utn.parkingcontrol.databinding.FragmentParkingBinding;

import java.util.ArrayList;

public class ParkingFragment extends Fragment {

    private GridView gvParking;
    private FragmentParkingBinding binding;
    private ImageView AgregarParking;



//    public void ListviewParking(View view) { setContentView(R.layout.listview_parking);}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.getContext(), "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        try{
            Cursor fila = db.rawQuery
                    ("select matricula,tiempo from users2 " , null);
            //  if (fila.moveToFirst()) {
            //     do {
            //         parkingList.add(new Parking(1, fila.getString(0), fila.getString(1)));
            //      } while (fila.moveToNext());
            //   }
        }
        catch (Exception e) {
            Toast.makeText(this.getContext(), "error:" + e , Toast.LENGTH_SHORT).show();

        }
        db.close();

        ParkingViewModel homeViewModel =
                new ViewModelProvider(this).get(ParkingViewModel.class);

        binding = FragmentParkingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        gvParking = binding.gvParking;
        SetParking(GetParkingBD(), this.getContext());

        AgregarParking = binding.btnNuevoParking;
        LayoutInflater lf = this.getLayoutInflater();

        AgregarParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = (User)getActivity().getIntent().getSerializableExtra(PutExtraConst.UserKey);
                Toast.makeText(v.getContext(),"llego", Toast.LENGTH_LONG).show();
                ParkingDialogAlert.CreateAlertDialog(v.getContext(), lf,user).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void SetParking(ArrayList<Parking> parkingList, Context context)
    {
        ParkingAdapter parkingAdapter = new ParkingAdapter(context, parkingList);
        gvParking.setAdapter(parkingAdapter);
    }

    private ArrayList<Parking> GetParkingBD()
    {


        ArrayList<Parking> parkingList = new ArrayList<>();
        User user = (User)getActivity().getIntent().getSerializableExtra(PutExtraConst.UserKey);




        // TODO: Setear el list con los datos de la BD.
        //  parkingList.add(new Parking(1, "ABC-332", "84122184"));
        //  parkingList.add(new Parking(2, "BRF-121", "23144412"));
        //  parkingList.add(new Parking(3, "PVC-552", "51244442"));

        return parkingList;
    }

}