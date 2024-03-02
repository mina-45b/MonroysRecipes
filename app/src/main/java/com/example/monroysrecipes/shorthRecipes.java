package com.example.monroysrecipes;

import android.net.Uri;
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
import android.widget.VideoView;

import com.example.monroysrecipes.databinding.FragmentShorthRecipesBinding;
import android.widget.MediaController;


public class shorthRecipes extends Fragment {

    NavController navController;
    VideoView videoView;
    ImageButton btnReturn, likeShort;

    FragmentShorthRecipesBinding binding;

    boolean isLike;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentShorthRecipesBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        navController = Navigation.findNavController(view);

        btnReturn = binding.btnBack2;

        likeShort = binding.loveShort;

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goHome);
            }
        });

        videoView = binding.shorth;

        Uri videoUri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.shorth_video);
        videoView.setVideoURI(videoUri);

        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

        isLike = false;

        likeShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLike) {
                    // Cambia a la otra imagen cuando ya está pintado
                    likeShort.setImageResource(R.drawable.love);
                } else {
                    // Pinta la imagen por primera vez
                    likeShort.setImageResource(R.drawable.love_on);
                }

                // Invierte el estado para el próximo clic
                isLike = !isLike;
            }
        });


    }
}