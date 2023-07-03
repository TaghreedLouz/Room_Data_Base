package com.devtaghreed.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devtaghreed.roomdatabase.databinding.ItemRvBinding;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Patient> patientsArray;
    onDelete_EditListener listener;

    public MyAdapter(List<Patient> patientsArray, onDelete_EditListener listener) {
        this.patientsArray = patientsArray;
        this.listener = listener;
    }

    public void setPatientsArray(List<Patient> patientsArray) {
        this.patientsArray = patientsArray;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRvBinding binding = ItemRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int pos = position;
        Patient p = patientsArray.get(pos);
        holder.Name.setText(p.getName());
        holder.Age.setText(p.getAge());
        holder.Address.setText(p.getAddress());

        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnDelete(pos);
            }
        });

        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnEdit(pos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return patientsArray.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView Name, Age, Address;
        ImageView Edit, Delete;

        public MyViewHolder(@NonNull ItemRvBinding binding) {
            super(binding.getRoot());
            Name = binding.NameTv;
            Age = binding.AgeTv;
            Address = binding.AddressTv;
            Edit = binding.EditImg;
            Delete = binding.DeleteImg;

        }
    }
}

