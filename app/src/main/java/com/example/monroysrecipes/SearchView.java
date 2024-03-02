package com.example.monroysrecipes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.monroysrecipes.databinding.FragmentSearchViewBinding;
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.nex3z.togglebuttongroup.button.CircularToggle;


public class SearchView extends Fragment {

    NavController navController;

    ImageButton btnBack;
    private FragmentSearchViewBinding binding;
    private ViewPager2 viewPager2;

    TextView advanced;

    CircularToggle circularToggle1, circularToggle2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = binding.viewPager;
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        navController = Navigation.findNavController(view);

        circularToggle1 = binding.choiceA;
        circularToggle2 = binding.choiceB;

        btnBack = binding.btnBack2;

        advanced = binding.textView30;

        SingleSelectToggleGroup single = (SingleSelectToggleGroup) binding.groupChoices;
        single.setOnCheckedChangeListener(new SingleSelectToggleGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SingleSelectToggleGroup group, int checkedId) {
                if (checkedId == circularToggle1.getId()) {
                    viewPager2.setCurrentItem(0, true);
                } else if (checkedId == circularToggle2.getId()){
                    viewPager2.setCurrentItem(1, true);
                }

            }
        });

        // Agrega un listener para detectar el cambio de página
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                // Actualiza el color del botón en función de la página seleccionada
                updateButtonColor(position);
            }
        });


        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advanceSearchDialog dialogFragment = new advanceSearchDialog();
                dialogFragment.setNavController(navController);
                dialogFragment.show(getParentFragmentManager(), "my_dialog_tag");

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_goSearch);
            }
        });

    }

    private void updateButtonColor(int position) {
        switch (position) {
            case 0:
                circularToggle1.setMarkerColor(R.color.yellow);
                 // Restaura el color del otro botón si es necesario
                break;
            case 1:
                circularToggle2.setMarkerColor(R.color.yellow);
           // Restaura el color del otro botón si es necesario
                break;
            // Añade más casos según sea necesario para más páginas
        }

    /*public void onPage1ButtonClick() {
        viewPager2.setCurrentItem(0, true); // Cambia a la página 1
    }

    public void onPage2ButtonClick() {
        viewPager2.setCurrentItem(1, true); // Cambia a la página 2
    } */
}

class CustomPagerAdapter extends FragmentStateAdapter {

    public CustomPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Devuelve el fragmento correspondiente a la posición.
        // Puedes implementar lógica específica para cada página aquí.
        // En este ejemplo, simplemente se crean dos fragmentos ficticios.
        if (position == 0) {
            return new RecipesSearch();
        } else {
            return new ProfilesSearch();
        }
    }

    @Override
    public int getItemCount() {
        // Devuelve la cantidad total de páginas.
        return 2; // En este ejemplo, hay dos páginas.
    }
}
}
