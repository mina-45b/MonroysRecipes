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
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.monroysrecipes.databinding.FragmentHomeBinding;
import com.example.monroysrecipes.databinding.FragmentShorthRecipesBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;

public class Home extends Fragment {

    NavController navController;

    FragmentHomeBinding binding;

    ImageButton btnLike, btnComment, btnOptions1;

    ShapeableImageView reelOne;
    TextView nameReelOne;
    ImageView saved1, saved2, saved3, saved4, goRecipe;

    boolean isSaved;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentHomeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        btnLike = binding.btnLikes;
        btnComment = binding.btnComents;

        reelOne = binding.reelOne;
        nameReelOne = binding.nameReelOne;

        saved1 = binding.saved1;
        saved2 = binding.saved2;
        saved3 = binding.saved3;
        saved4 = binding.saved4;

        btnOptions1 = binding.btnOptions1;

        goRecipe = binding.goRecipeList1;

        setupSpinnerBasic();

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goLikes);
            }
        });


        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goComments);
            }
        });

        reelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goShorthRecipes);
            }
        });

        nameReelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goShorthRecipes);
            }
        });

        isSaved = false;

        View.OnClickListener savedOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView) v;

                if (isSaved) {
                    // Cambia a la otra imagen cuando ya está pintado
                    imageView.setImageResource(R.drawable.saved);
                } else {
                    // Pinta la imagen por primera vez
                    imageView.setImageResource(R.drawable.saved_on);
                }

                // Invierte el estado para el próximo clic
                isSaved = !isSaved;
            }
        };

        saved1.setOnClickListener(savedOnClickListener);
        saved2.setOnClickListener(savedOnClickListener);
        saved3.setOnClickListener(savedOnClickListener);
        saved4.setOnClickListener(savedOnClickListener);

        goRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goRecipe);
            }
        });

        btnOptions1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // En tu actividad o fragmento
                BottomSheet bottomSheetFragment = new BottomSheet();
                bottomSheetFragment.show(getParentFragmentManager(), bottomSheetFragment.getTag());
            }
        });

    }

    public void setupSpinnerBasic() {
        Spinner spinner = binding.shortRecipes;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.shortRecipes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}