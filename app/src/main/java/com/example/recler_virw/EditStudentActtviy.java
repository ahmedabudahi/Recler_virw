package com.example.recler_virw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recler_virw.databinding.ActivityEditStudentActtviyBinding;

public class EditStudentActtviy extends AppCompatActivity {

    ActivityEditStudentActtviyBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentActtviyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nameETT.setText(getIntent().getStringExtra("studentName"));

        binding.AddBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.nameETT.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newStudentName",name);
                intent.putExtra("Posion",getIntent().getIntExtra("Posion",-1));
                setResult(101,intent);
                finish();
            }
        });


    }
}