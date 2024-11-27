package com.example.mycouers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycouers.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

  MyRepository myRepository;
  MyViewModel myViewModel;
    ActivityMainBinding binding;
    MyDatabase database;
    private final ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<androidx.activity.result.ActivityResult>() {
                        @Override
                        public void onActivityResult(androidx.activity.result.ActivityResult result) {
                            if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                                Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                                if (photo != null) {
                                    byte[] photoBytes = Convert.getBitMapByteArray(photo);
                                Student student=new Student();
                                student.setPhoto(photoBytes);
                                database.studentDao().updateStudent(student);
                            }
                        }}
                    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        if (myViewModel == null) {
            Log.e("MainActivity", "ViewModel is null");
        }


        binding.btnCammera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraLauncher.launch(intent);
            }
        });
        binding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            myViewModel.insertCoures(new Coures("java", 12));
                        } catch (NullPointerException e) {
                            Log.e("MainActivity", "Error inserting course", e);
                        }

//                        myViewModel.insertCoures(new Coures("java", 12));
//                        myViewModel.insertCoures(new Coures("css", 45));
//                        myViewModel.insertCoures(new Coures("html", 30));
//
                    }
                }).start();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }
}
