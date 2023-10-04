package com.example.recler_virw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recler_virw.databinding.ItemStudentBinding;

import java.util.ArrayList;

public class Student_Adpter extends RecyclerView.Adapter<Student_Adpter.StudentViewholder> {
    ArrayList<Student>students;
    Student_lesener lesener;

    public Student_Adpter(ArrayList<Student> students ,Student_lesener lesener) {
        this.students = students;
        this.lesener=lesener;
    }

    @NonNull
    @Override
    public StudentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        ItemStudentBinding binding = ItemStudentBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false);

        return new StudentViewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewholder holder, int position) {
        int xxx = position;
         Student s = students.get(xxx);

        holder.studenetid.setText(String.valueOf(s.getId()));
        holder.studenetname.setText(s.getName());
        holder.studenetGPA.setText(String.valueOf(s.getGPA()));
        holder.studenetfiled.setText(s.getFiled());

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               lesener.onDelete(xxx);


            }
        });

        holder.EditIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  lesener.onEdit(xxx);
            }
        });



    }

    @Override
    public int getItemCount() {
        return students.size() ;
    }

    class  StudentViewholder extends RecyclerView.ViewHolder {
        TextView studenetname , studenetGPA, studenetfiled , studenetid;
        ImageView deleteIv , EditIV ;
        public StudentViewholder(ItemStudentBinding binding) {
            super(binding.getRoot());

            studenetid=binding.idET;
            studenetname =binding.nameET ;
            studenetGPA= binding.gpaET;
            studenetfiled=binding.filedET;
            deleteIv=binding.deleteIV;
            EditIV = binding.EdIV;

        }
    }
}
