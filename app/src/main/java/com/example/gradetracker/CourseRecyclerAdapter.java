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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    private List<Course> mCourses = new ArrayList<Course>();
    private OnCourseListener mOnCourseListener;
    private Context mContext;
    Course temp;

    public CourseRecyclerAdapter(Context context, ArrayList<Course> courses, OnCourseListener onCourseListener) {
        mContext = context;
        mCourses = courses;
        mOnCourseListener = onCourseListener;
    }


    @NonNull
    @Override
    public CourseRecyclerAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_course, parent, false);
        return new CourseViewHolder(view, mOnCourseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRecyclerAdapter.CourseViewHolder holder, int position) {
        holder.courseName.setText(mCourses.get(position).getName());
        holder.courseGrade.setText(mCourses.get(position).getCurrentGrade());
        holder.popUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, v);
                popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                Toast.makeText(mContext, "Edit Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.delete:
                                temp = new Course(mCourses.get(position).getName(), mCourses.get(position).getGradeBreakdown());
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
        mCourses.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mCourses.size());
        Snackbar.make(view, temp.getName() + " was removed.", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCourses.add(position, temp);
                        notifyItemInserted(position);
                        notifyItemRangeChanged(position, mCourses.size());
                    }
                }).setActionTextColor(mContext.getResources().getColor(R.color.undo_button)).show();
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView courseName;
        public TextView courseGrade;
        private ImageView popUpMenu;
        OnCourseListener onCourseListener;

        public CourseViewHolder(View itemView, OnCourseListener onCourseListener) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name);
            courseGrade = itemView.findViewById(R.id.course_grade);
            popUpMenu = itemView.findViewById(R.id.optionsMenu);
            this.onCourseListener = onCourseListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onCourseListener.onCourseClick(getAdapterPosition());
        }
    }

    public interface OnCourseListener {
        void onCourseClick(int position);
    }
}
