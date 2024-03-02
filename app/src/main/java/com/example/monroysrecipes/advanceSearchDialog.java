package com.example.monroysrecipes;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;

public class advanceSearchDialog extends DialogFragment {
    private NavController navController;

    // Otros campos y métodos

    public void setNavController(NavController navController) {
        this.navController = navController;
    }

    TextView moreTime, moreServing;

    int serving =0;
    int minuts = 0;

    public advanceSearchDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Crea un objeto Dialog y configúralo
        Dialog dialog = new Dialog(requireContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_advanced_search);

        // Configura las dimensiones y la posición del diálogo
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
        }

        // Configura el botón de cierre del diálogo
        ImageButton closeButton = dialog.findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // Cierra el diálogo al hacer clic en el botón de cierre
            }
        });

        moreTime = dialog.findViewById(R.id.viewMore1);
        moreServing = dialog.findViewById(R.id.viewMore2);

        ImageButton plus1 = dialog.findViewById(R.id.plus1);
        ImageButton minus1 = dialog.findViewById(R.id.minus1);

        ImageButton plus2 = dialog.findViewById(R.id.plus2);
        ImageButton minus2 = dialog.findViewById(R.id.minus2);

        Button searchRecipe = dialog.findViewById(R.id.searchrecipe);

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minuts++;
                moreTime.setText(String.valueOf(minuts));
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minuts != 0) {
                    minuts--;
                    moreTime.setText(String.valueOf(minuts));
                }
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serving++;
                moreServing.setText(String.valueOf(serving));
            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (serving != 0) {
                    serving--;
                    moreServing.setText(String.valueOf(serving));
                }
            }
        });



        searchRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController != null) {
                    navController.navigate(R.id.action_goRecipe);
                    dismiss(); // Cierra el diálogo después de la navegación
                }
            }
        });

        return dialog;
    }

}
