package com.devtaghreed.roomdatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devtaghreed.roomdatabase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onDelete_EditListener{

    ActivityMainBinding binding;
    MyViewModel viewModel;
    MyAdapter adapter;
    List<Patient>patients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding.AddFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),AddActivity.class));
            }
        });

        viewModel.GetAllPatient().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                MainActivity.this.patients = patients;
                adapter = new MyAdapter(patients , MainActivity.this);
                binding.CourseRv.setAdapter(adapter);
                binding.CourseRv.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
            }
        });


    }

    @Override
    public void OnDelete(int position) {
        viewModel.DeletePatient(patients.get(position));
    }

    @Override
    public void OnEdit(int position) {
        Intent intent = new Intent(MainActivity.this , EditActivity.class);
        Patient patient = patients.get(position);

        intent.putExtra("patientId",patients.get(position).getId());
        intent.putExtra("patientName",patients.get(position).getName());
        intent.putExtra("patientAge",patients.get(position).getAge());
        intent.putExtra("patientAddress",patients.get(position).getAddress());
        startActivity(intent);
    }
}