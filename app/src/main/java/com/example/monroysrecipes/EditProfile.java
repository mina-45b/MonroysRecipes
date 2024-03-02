package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;

import com.example.monroysrecipes.databinding.FragmentEditProfileBinding;


public class EditProfile extends Fragment {

    NavController navController;

    FragmentEditProfileBinding binding;

    ImageButton btnBack, okEdit, goChange;

    TextView changeAccountText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        ProffesionalViewModel viewModel = new ViewModelProvider(requireActivity()).get(ProffesionalViewModel.class); //Instancia del viewModel

        btnBack = binding.btnBack;
        okEdit = binding.imageEdit;
        goChange = binding.goChange;
        changeAccountText = binding.editProfile6;


        if(viewModel.isProfessional()) {
            changeAccountText.setText(R.string.changoToNormal);
        } else {
            changeAccountText.setText(R.string.chageToProfessional);
        }

        Log.d("EditProfile", "isProfessional: " + viewModel.isProfessional());


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goProfile);
            }
        });

        okEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goProfile);
            }
        });

        goChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (viewModel.isProfessional()) {
                    navController.navigate(R.id.action_goNormalAccount);
                } else {
                    navController.navigate(R.id.action_goProffesionalAccount);
                }
            }
        });

    }

}