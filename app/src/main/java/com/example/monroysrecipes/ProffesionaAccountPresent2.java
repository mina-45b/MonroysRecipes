package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.monroysrecipes.databinding.FragmentProffesionaAccountPresent1Binding;
import com.example.monroysrecipes.databinding.FragmentProffesionaAccountPresent2Binding;

public class ProffesionaAccountPresent2 extends Fragment {

    FragmentProffesionaAccountPresent2Binding binding;

    NavController navController;
    Button buttonAccept;
    ImageButton buttonBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentProffesionaAccountPresent2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        ProffesionalViewModel viewModel = new ViewModelProvider(requireActivity()).get(ProffesionalViewModel.class);

        buttonAccept = binding.buttonAcept;

        buttonBack = binding.btnBack;

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    viewModel.setProfessional(true);

                navController.navigate(R.id.action_goProfile);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goPA1);
            }
        });
        }

}