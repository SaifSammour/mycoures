package com.example.mycouers;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;

public class Student_Adabter extends ListAdapter<Student, Student_Adabter.StudentViewHolder> {




    protected Student_Adabter(@NonNull DiffUtil.ItemCallback<Student> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StudentViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student current = getItem(position);
        holder.bind(current);
    }


    public static class StudentViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView departmentTextView;
        private TextView idTextView;
        private TextView birthDateTextView;


        public StudentViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tv_img);
            nameTextView = itemView.findViewById(R.id.tv_name);
            departmentTextView = itemView.findViewById(R.id.tv_department);
            idTextView = itemView.findViewById(R.id.tv_id);
            birthDateTextView = itemView.findViewById(R.id.tv_date);
        }




        public void bind(Student student) {
            nameTextView.setText(student.getName_Student());
            departmentTextView.setText(student.getDepartment());
            idTextView.setText(String.valueOf(student.getId_Student()));
            birthDateTextView.setText(student.getDateOfBirth());
        }


            public static StudentViewHolder create(ViewGroup parent){
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.student_item, (ViewGroup) parent, false);
                return new StudentViewHolder(view);

                 }
            }


            private static class StudentDiff extends DiffUtil.ItemCallback<Student> {

                @Override
                public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.getId_Student() == newItem.getId_Student();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                    return oldItem.getName_Student().equals(newItem.getName_Student()) &&
                            oldItem.getDepartment().equals(newItem.getDepartment()) &&
                            oldItem.getDateOfBirth()== (newItem.getDateOfBirth())&&
                            oldItem.getPhoto().equals(newItem.getPhoto());

                }

            }

        }


