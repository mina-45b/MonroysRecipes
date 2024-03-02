package com.example.monroysrecipes;

import android.graphics.Color;
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

import com.example.monroysrecipes.databinding.FragmentStartRegisterBinding;
import com.example.monroysrecipes.databinding.FragmentStatisticsBinding;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;

public class Statistics extends Fragment {

    FragmentStatisticsBinding binding;
    NavController navController;

    ImageButton buttonBack;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentStatisticsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        buttonBack = binding.btnBack;

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goProfile);
            }
        });

        BarChart mBarChart = (BarChart) view.findViewById(R.id.barchart);

        mBarChart.addBar(new BarModel(2.3f, 0xFF123456));
        mBarChart.addBar(new BarModel(2.f,  0xFF343456));
        mBarChart.addBar(new BarModel(3.3f, 0xFF563456));
        mBarChart.addBar(new BarModel(1.1f, 0xFF873F56));
        mBarChart.addBar(new BarModel(2.7f, 0xFF56B7F1));
        mBarChart.addBar(new BarModel(2.f,  0xFF343456));
        mBarChart.addBar(new BarModel(0.4f, 0xFF1FF4AC));
        mBarChart.addBar(new BarModel(4.f,  0xFF1BA4E6));

        mBarChart.startAnimation();

        PieChart mPieChart = (PieChart) view.findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Japanese-style-Lunch", 15, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Toast with harm", 25, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Latter macciato", 35, Color.parseColor("#CDA67F")));
        mPieChart.addPieSlice(new PieModel("FluffyPancakes", 9, Color.parseColor("#FED70E")));


        mPieChart.startAnimation();
    }
}