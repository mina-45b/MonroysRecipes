package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.monroysrecipes.databinding.FragmentSearchBinding;
public class Search extends Fragment {

    NavController navController;
    FragmentSearchBinding binding;

    ImageButton catergories1, mic;

    SearchView searchViewBar;

    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentSearchBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        catergories1 = binding.goCategories1;

        searchViewBar = binding.searchView1;

        layout = binding.linearLayout4;

        mic = binding.mic1;

        catergories1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goCategories1);
            }
        });


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goSearchView);
            }
        });

        /*searchViewBar.setFocusable(false);
        searchViewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goSearchView);
            }
        });*/


        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voiceSearch dialogFragment = new voiceSearch();
                dialogFragment.show(getParentFragmentManager(), "my_dialog_tag");
            }
        });

    }
}