package com.devtaghreed.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.devtaghreed.roomdatabase.databinding.ActivityAddBinding;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    ActivityAddBinding binding;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Add");
       viewModel= new ViewModelProvider(AddActivity.this).get(MyViewModel.class);

        binding.SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.NameEt.getText().toString().trim();
                String age = binding.AgeEt.getText().toString().trim();
                String address = binding.AddressEt.getText().toString().trim();


                if (name.isEmpty() && age.isEmpty() && address.isEmpty()){
                    Toast.makeText(AddActivity.this, "Fill them all", Toast.LENGTH_SHORT).show();
                }else{
                    viewModel.InsertPatient(new Patient(name , age , address));
                    Toast.makeText(AddActivity.this, "Add Successful", Toast.LENGTH_SHORT).show();
                }

                if (name.isEmpty()) {
                    binding.NameEt.setError("Please Enter your Name");
                }
                else if (age.isEmpty()) {
                    binding.AgeEt.setError("Please Enter your Age");
                }
                else if (address.isEmpty()) {
                    binding.AddressEt.setError("Please Enter your Address");
                }else {
                    Toast.makeText(AddActivity.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    finish();

                }
            }
        });
    }
}