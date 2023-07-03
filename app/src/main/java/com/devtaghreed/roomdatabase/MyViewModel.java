package com.devtaghreed.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
    }

    void InsertPatient(Patient patient) {
        repository.InsertPatient(patient);
    }

    void UpdatePatient(Patient patient) {
        repository.UpdatePatient(patient);
    }

    void DeletePatient(Patient patient) {
        repository.DeletePatient(patient);
    }

    LiveData<List<Patient>> GetAllPatient() {
        return repository.GetAllPatient();
    }

}



