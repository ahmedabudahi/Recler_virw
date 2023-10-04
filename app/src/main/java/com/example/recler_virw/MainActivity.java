package com.example.recler_virw;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recler_virw.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Student_lesener {
        ActivityMainBinding binding ;
    Student_Adpter adpter;
    ArrayList<Student>students;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null &&  result.getResultCode()  == 101  ){

    students.get(result.getData().getIntExtra("Posion",-1))
                                .setName(result.getData().getStringExtra("newStudentName"));
                         adpter.notifyDataSetChanged();


                    }



                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        students=new ArrayList<>();
        students.add(new Student(120223934,12.5,"Ahmed","BOY"));
        students.add(new Student(1202236998,50.5,"Neam","GIRIL"));


         adpter = new Student_Adpter(students,this);

        binding.RescleView.setAdapter(adpter);

        binding.RescleView.setLayoutManager(new LinearLayoutManager
                (this, RecyclerView.VERTICAL,false));




        binding.addbtoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.add(new Student(120,99,binding.Edname.getText().toString(),"Mobil"));
                adpter.notifyItemInserted(students.size()-1);
            }
        });
 



    }


    @Override
    public void onEdit(int pos) {
        Intent intent =new Intent(this,EditStudentActtviy.class);
        intent.putExtra("NameStudent",students.get(pos).getName());
        intent.putExtra("Posion",pos);
       launcher.launch(intent);


     }

    @Override
    public void onDelete(int pos) {
        students.remove(pos);
        adpter.notifyItemRemoved(pos);

    }
}