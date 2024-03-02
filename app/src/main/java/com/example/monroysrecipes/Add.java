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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.monroysrecipes.databinding.FragmentAddBinding;

public class Add extends Fragment {

    NavController navController;

    FragmentAddBinding binding;

    ImageView galleryImage;

    TextView time1, next;

    boolean isShort;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Cargar el fragmento secundario
        getChildFragmentManager().beginTransaction()
                .replace(R.id.containerImages, new Images())  // Utiliza el ID correcto
                .commit();

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);

        setupSpinnerBasic1();
        setupSpinnerBasic2();

        isShort = false;

        galleryImage = binding.imageView10;
        time1 = binding.time1;
        next = binding.next;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShort) {
                    navController.navigate(R.id.action_goAddShort);
                } else {
                    navController.navigate(R.id.action_goAddRecipe);
                }

            }
        });

    }

    public void setupSpinnerBasic1() {
        Spinner spinner = binding.postRecipe;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.addRecipes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtén la opción seleccionada
                String selectedOption = spinner.getSelectedItem().toString();

                // Cambia la imagen de imageView10 según la opción seleccionada
                switch (selectedOption) {
                    case "New recipe":
                        isShort = false;
                        galleryImage.setImageResource(R.drawable.cam0);
                        time1.setVisibility(View.GONE);

                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.containerImages, new Images())
                                .commit();
                        break;
                    case "New short":
                        isShort = true;
                        galleryImage.setImageResource(R.drawable.vid0);
                        time1.setVisibility(View.VISIBLE);

                        // Reemplaza el contenido de containerImages con el fragmento NewShortFragment
                        getChildFragmentManager().beginTransaction()
                                .replace(R.id.containerImages, new Videos())
                                .commit();

                        break;
                    // Agrega más casos según tus opciones
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        }

    public void setupSpinnerBasic2() {
        Spinner spinner = binding.galleryOptions;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.gallery, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

}