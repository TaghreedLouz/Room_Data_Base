package com.devtaghreed.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    void InsertPatient(Patient patient);

    @Update
    void UpdatePatient(Patient patient);

    @Delete
    void DeletePatient(Patient patient);

    @Query("SELECT * FROM Patient ORDER BY name ASC")
    LiveData<List<Patient>> GetAllPatient();

}
