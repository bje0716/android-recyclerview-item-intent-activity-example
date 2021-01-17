package com.grapefruit.radio;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.grapefruit.radio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnCallbackListener {

    private ActivityMainBinding binding;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new MainAdapter(this, this);

        binding.recycler.setHasFixedSize(true);
        binding.recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setAdapter(adapter);
    }

    @Override
    public void onCallback(String item) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }
}