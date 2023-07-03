package com.devtaghreed.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Patient {
    @PrimaryKey(autoGenerate = true)
    int id;
    @NonNull
    String name;
    String age;
    String address;


    public Patient( String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Patient(ArrayList<Patient> patientArrayList) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
