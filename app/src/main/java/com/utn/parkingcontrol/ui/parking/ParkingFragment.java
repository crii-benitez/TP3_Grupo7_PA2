package com.utn.parkingcontrol.ui.parking;

import android.content.ContentValues;
import android.content.Context;
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
                Toast.makeText(v.getContext(),"llego", Toast.LENGTH_LONG).show();
                ParkingDialogAlert.CreateAlertDialog(v.getContext(), lf).show();
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
        User user = (User)getActivity().getIntent().getSerializableExtra(PutExtraConst.UserKey);
        ArrayList<Parking> parkingList = new ArrayList<>();

        // TODO: Setear el list con los datos de la BD.
        //   parkingList.add(new Parking(1, user.getName(), "84122184"));
        //    parkingList.add(new Parking(2, "BRF-121", "23144412"));
        //    parkingList.add(new Parking(3, "PVC-552", "51244442"));

        return parkingList;
    }

}