package com.utn.parkingcontrol.ui.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.utn.parkingcontrol.MainActivity;
import com.utn.parkingcontrol.MainMenuActivity;
import com.utn.parkingcontrol.PutExtraConst;
import com.utn.parkingcontrol.R;
import com.utn.parkingcontrol.databinding.FragmentMyaccountBinding;

public class MyAccountFragment extends Fragment {

    private FragmentMyaccountBinding binding;

    private View.OnClickListener logoutButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            Toast.makeText(getActivity(), "Sesión cerrada", Toast.LENGTH_SHORT).show();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyAccountViewModel galleryViewModel =
                new ViewModelProvider(this).get(MyAccountViewModel.class);

        binding = FragmentMyaccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Button logout = (Button)view.findViewById(R.id.btnLogout);
        logout.setOnClickListener(logoutButtonClickListener);

        //TextView textView = binding.tvDataAccount;
        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}