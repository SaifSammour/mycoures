package com.example.mycouers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mycouers.databinding.ActivityMain2Binding;
import com.example.mycouers.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
   ActivityMain2Binding binding;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    AdabterAlldata adabterAlldata;
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
     binding.rvCouers.setLayoutManager(new LinearLayoutManager(this));
        adabterAlldata = new AdabterAlldata(new AdabterAlldata.CourseDiff());
        binding.rvCouers.setAdapter(adabterAlldata);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getAllCoures().observe(this, new Observer<List<Coures>>() {
            @Override
            public void onChanged(List<Coures> courses) {
                if (courses != null) {
                    adabterAlldata.submitList(courses);
                } else {
                    Log.e("MainActivity", "Courses data is null");
                }
            }
        });
    }
  }
