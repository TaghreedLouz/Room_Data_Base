package com.devtaghreed.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.devtaghreed.roomdatabase.databinding.ActivityAddBinding;
import com.devtaghreed.roomdatabase.databinding.ActivityEditBinding;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    ActivityEditBinding binding;
    ArrayList<Patient> patientArrayList;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Edit");
        patientArrayList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        Intent intent = getIntent();
        int patientId = intent.getIntExtra("patientId", 0);
        String patientName = intent.getStringExtra("patientName");
        String patientAge = intent.getStringExtra("patientAge");
        String patientAddress = intent.getStringExtra("patientAddress");

        binding.NameEt.setText(patientName);
        binding.AgeEt.setText(patientAge);
        binding.AddressEt.setText(patientAddress);

        binding.EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.NameEt.getText().toString().trim();
                String age = binding.AgeEt.getText().toString().trim();
                String address = binding.AddressEt.getText().toString().trim();

                if (name.isEmpty()) {
                    binding.NameEt.setError("Please Enter your Name");
                } else if (age.isEmpty()) {
                    binding.AgeEt.setError("Please Enter your Age");
                } else if (address.isEmpty()) {
                    binding.AddressEt.setError("Please Enter your Address");
                } else {
                    Patient patient = new Patient(name, age, address);
                    patient.setId(patientId);
                    viewModel.UpdatePatient(patient);
                    Toast.makeText(EditActivity.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
