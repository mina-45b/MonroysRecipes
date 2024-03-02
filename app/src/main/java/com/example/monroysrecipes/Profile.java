package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.monroysrecipes.databinding.FragmentForgotPasswordBinding;
import com.example.monroysrecipes.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Profile extends Fragment {
    NavController navController;
    FragmentProfileBinding binding;

    TabLayout tabLayout;
   ViewPager2 viewPager;

   ImageButton settings, graphics, messages;
   TextView editProfile;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentProfileBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        ProffesionalViewModel viewModel = new ViewModelProvider(requireActivity()).get(ProffesionalViewModel.class);

        viewPager = binding.viewPager;
        tabLayout = binding.tabLayout;

        settings = binding.imageButton;

        editProfile = binding.textView8;

        graphics = binding.graphics;
        messages = binding.messages;

        if (viewModel.isProfessional){
            graphics.setVisibility(View.VISIBLE);
            messages.setVisibility(View.VISIBLE);
        } else {
            graphics.setVisibility(View.GONE);
            messages.setVisibility(View.GONE);
        }



        graphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goStatistics);
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goChats);
            }
        });


        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new bookRecipes();
                    case 1:
                        return new shorthUserRecipes();
                    case 2:
                        return new savedRecipes();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });

        int[] tabIcons = {
                R.drawable.book,
                R.drawable.record,
                R.drawable.saved
        };

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setIcon(tabIcons[position])
        ).attach();


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goSettings);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goEditProfile);
            }
        });


    }


}