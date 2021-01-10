package com.example.gradetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ViewHolder> {

    private List<Assessment> assessmentList;

    public ChildRecyclerAdapter(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.each_assessment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.childName.setText(assessmentList.get(position).getName());
        holder.childGrade.setText(Double.toString(assessmentList.get(position).getGrade()) + "%");
    }

    @Override
    public int getItemCount() {
        return assessmentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView childName;
        TextView childGrade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            childName = itemView.findViewById(R.id.child_name);
            childGrade = itemView.findViewById(R.id.child_grade);
        }
    }
}
