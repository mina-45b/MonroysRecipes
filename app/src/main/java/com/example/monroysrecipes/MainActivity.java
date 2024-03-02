package com.example.monroysrecipes;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.monroysrecipes.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());


        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.yellow));
        }

        binding.bottomNavView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.homeItem) {
                navController.navigate(R.id.home);
            } else if (itemId == R.id.searchItem) {
                navController.navigate(R.id.search);
            } else if (itemId == R.id.addItem) {
                navController.navigate(R.id.add);
            } else if (itemId == R.id.listItem) {
                navController.navigate(R.id.list);
            }else if (itemId == R.id.profileItem) {
                navController.navigate(R.id.profile);
            }

            return true;
        });

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(NavController controller, NavDestination destination, Bundle arguments) {

                // Oculta la BottomNavigationView si el fragmento actual no es "list" ni "home"
                Set<Integer> hiddenIds = new HashSet<>(Arrays.asList(R.id.home, R.id.search, R.id.list, R.id.profile, R.id.add));

                if (hiddenIds.contains(destination.getId())) {
                    binding.bottomNavView.setVisibility(View.VISIBLE);
                } else {
                    binding.bottomNavView.setVisibility(View.GONE);
                }
            }
        });

    }
}