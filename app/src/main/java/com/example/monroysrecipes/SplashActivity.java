package com.example.monroysrecipes;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_start_secuence);

        // Agregar un retraso de 1000 milisegundos (1 segundo)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation();
            }
        }, 1000);

       if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.yellow));
        }

    }


    private void startAnimation() {
        ImageView imageViewLog = findViewById(R.id.imageViewLog);

        // Cambiar la visibilidad a VISIBLE antes de iniciar la animación
        imageViewLog.setVisibility(View.VISIBLE);

        // Cargar la animación desde el nuevo archivo
        Animation appearAndFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Asignar la animación a la ImageView
        imageViewLog.startAnimation(appearAndFadeIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Iniciar la actividad principal después de la animación
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, getResources().getInteger(R.integer.splash_screen_duration));
    }


}
