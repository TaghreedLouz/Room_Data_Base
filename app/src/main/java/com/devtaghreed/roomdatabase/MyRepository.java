package com.devtaghreed.roomdatabase;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class MyRepository {

    private PatientDao patientDao;
    private LiveData<List<Patient>> AllPatient;

    public MyRepository(Application application) {
        MyRoomDataBase db = MyRoomDataBase.getDatabase(application);
        patientDao = db.patientDao();
        AllPatient = patientDao.GetAllPatient();
    }

    void InsertPatient(Patient patient){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.InsertPatient(patient);
            }
        });
    }


    void UpdatePatient(Patient patient){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.UpdatePatient(patient);
            }
        });
    }


    void DeletePatient(Patient patient){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patientDao.DeletePatient(patient);
            }
        });
    }

    LiveData<List<Patient>> GetAllPatient(){
       return AllPatient;
    }

}
