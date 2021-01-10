package com.example.gradetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ExampleViewHolder> {
    private ArrayList<Course> courseList;
    private Context menuContext;
    View view;
    Course temp;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;
        public TextView courseGrade;
        private ImageView popUpMenu;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name);
            courseGrade = itemView.findViewById(R.id.course_grade);
            popUpMenu = itemView.findViewById(R.id.optionsMenu);
        }
    }

    public CourseAdapter(Context context, ArrayList<Course> courseList) {
        this.courseList = courseList;
        this.menuContext = context;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_course, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Course currentItem = courseList.get(position);
        holder.courseName.setText(currentItem.getName());
        holder.courseGrade.setText(currentItem.getCurrentGrade());
        holder.popUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(menuContext, v);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                Toast.makeText(menuContext, "Edit Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delete:
                                temp = new Course(courseList.get(position).getName(), courseList.get(position).getGradeBreakdown());
                                deleteCourse(position, v);
                                break;
                        }
                        return true;
                    }
                });
            }
        });
    }

    private void deleteCourse(int position, View view) {
        courseList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, courseList.size());
        Snackbar.make(view, temp.getName() + " Has Been Removed.", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseList.add(position, temp);
                notifyItemInserted(position);
                notifyItemRangeChanged(position, courseList.size());
            }
        }).setActionTextColor(menuContext.getResources().getColor(R.color.undo_button)).show();
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}