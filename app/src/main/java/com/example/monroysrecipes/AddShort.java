package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.monroysrecipes.databinding.FragmentAddShortBinding;
import com.example.monroysrecipes.databinding.FragmentStartOptionsBinding;


public class AddShort extends Fragment {

    NavController navController;

    FragmentAddShortBinding binding;

    ImageButton btnBack;

    Button share, draft;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentAddShortBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        btnBack = binding.btnBack2;

        draft = binding.button;
        share = binding.button2;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goAdd);
            }
        });

        View.OnClickListener Home = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goAdd);
            }
        };

        draft.setOnClickListener(Home);
        share.setOnClickListener(Home);
    }
}