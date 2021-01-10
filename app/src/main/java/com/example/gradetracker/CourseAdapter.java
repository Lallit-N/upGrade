package com.example.gradetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ExampleViewHolder> {
    private ArrayList<Course> courseList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name);
        }
    }

    public CourseAdapter(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_row, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Course currentItem = courseList.get(position);
        holder.courseName.setText(currentItem.getName());
    }
    @Override
    public int getItemCount() {
        return courseList.size();
    }
}