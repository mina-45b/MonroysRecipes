package com.example.monroysrecipes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ProffesionalViewModel extends AndroidViewModel {

    boolean isProfessional;
    public ProffesionalViewModel(@NonNull Application application) {
        super(application);

        isProfessional = false;

    }

    public boolean isProfessional() {
        return isProfessional;
    }

    public void setProfessional(boolean professional) {
        isProfessional = professional;
    }
}
