package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.example.monroysrecipes.databinding.FragmentCommentsViewBinding;



public class CommentsView extends Fragment {

    FragmentCommentsViewBinding binding;

    ImageButton love1, love2, love3, love4, love5, love6, love7, love8;
    boolean isLike;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentCommentsViewBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        isLike = false;

        love1 = binding.imageLove1;
        love2 = binding.imageLove2;
        love3 = binding.imageLove3;
        love4 = binding.imageLove4;
        love5 = binding.imageLove5;
        love6 = binding.imageLove6;
        love7 = binding.imageLove7;
        love8 = binding.imageLove8;


        View.OnClickListener likeOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imageButton = (ImageButton) v;

                if (isLike) {
                    // Cambia a la otra imagen cuando ya está pintado
                    imageButton.setImageResource(R.drawable.love);
                } else {
                    // Pinta la imagen por primera vez
                    imageButton.setImageResource(R.drawable.love_on);
                }

                // Invierte el estado para el próximo clic
                isLike = !isLike;
            }
        };

        love1.setOnClickListener(likeOnclickListener);
        love2.setOnClickListener(likeOnclickListener);
        love3.setOnClickListener(likeOnclickListener);
        love4.setOnClickListener(likeOnclickListener);
        love5.setOnClickListener(likeOnclickListener);
        love6.setOnClickListener(likeOnclickListener);
        love7.setOnClickListener(likeOnclickListener);
        love8.setOnClickListener(likeOnclickListener);


    }
}