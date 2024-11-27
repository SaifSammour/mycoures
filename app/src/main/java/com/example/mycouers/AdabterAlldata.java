package com.example.mycouers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;



public class AdabterAlldata extends ListAdapter<Coures, AdabterAlldata.CourseViewHolder> {


    protected AdabterAlldata(@NonNull DiffUtil.ItemCallback<Coures> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CourseViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Coures current = getItem(position);
        holder.bind(current);
    }


    public static class CourseViewHolder extends RecyclerView.ViewHolder {


        private TextView courseNameTextView;
        private TextView courseNumberTextView;
        private TextView studentCountTextView;

        public CourseViewHolder(View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseName);
            courseNumberTextView = itemView.findViewById(R.id.courseNumber);
            studentCountTextView = itemView.findViewById(R.id.studentCount);
        }

        public void bind(Coures course) {
            courseNameTextView.setText(course.getCouers_Name());
            courseNumberTextView.setText(course.getId());
            studentCountTextView.setText(String.valueOf(course.getNum_ofStudent()));
        }


        public static CourseViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.couers_item, parent, false);
            return new CourseViewHolder(view);
        }
    }


    public static class CourseDiff extends DiffUtil.ItemCallback<Coures> {

        @Override
        public boolean areItemsTheSame(@NonNull Coures oldItem, @NonNull Coures newItem) {

            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Coures oldItem, @NonNull Coures newItem) {

            return oldItem.getCouers_Name().equals(newItem.getCouers_Name()) &&
                    oldItem.getId()==(newItem.getId()) &&
                    oldItem.getNum_ofStudent() == newItem.getNum_ofStudent();
        }
    }
}


