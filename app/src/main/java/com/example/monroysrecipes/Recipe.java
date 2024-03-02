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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monroysrecipes.databinding.FragmentAddBinding;
import com.example.monroysrecipes.databinding.FragmentRecipeBinding;


public class Recipe extends Fragment {
    NavController navController;

    FragmentRecipeBinding binding;
    ImageView savedBtn;

    ImageButton btnBack, likeRecipe, goList;
    TextView numLikes;
    int likesCount;

    boolean isSaved, isLike;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRecipeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        // Cargar el fragmento secundario
        getChildFragmentManager().beginTransaction()
                .replace(R.id.containerComments, new CommentsView())  // Utiliza el ID correcto
                .commit();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        btnBack = binding.btnBack2;

        savedBtn = binding.saved1;

        likeRecipe = binding.imageLove;

        goList = binding.imageList;

        numLikes  = binding.numLikes;

        likesCount = 616;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goHome);
            }
        });

        isSaved = false;

        savedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSaved) {
                    // Cambia a la otra imagen cuando ya está pintado
                    savedBtn.setImageResource(R.drawable.saved);
                } else {
                    // Pinta la imagen por primera vez
                    savedBtn.setImageResource(R.drawable.saved_on);
                }

                // Invierte el estado para el próximo clic
                isSaved = !isSaved;

            }
        });

        likeRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLike) {
                    // Cambia a la otra imagen cuando ya está pintado
                    likeRecipe.setImageResource(R.drawable.love);
                    likesCount--;
                    numLikes.setText("" + likesCount);
                } else {
                    // Pinta la imagen por primera vez
                    likeRecipe.setImageResource(R.drawable.love_on);
                    likesCount++;
                    numLikes.setText("" + likesCount);
                }

                // Invierte el estado para el próximo clic
                isLike = !isLike;
            }
        });

        goList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goList);
            }
        });

    }
}