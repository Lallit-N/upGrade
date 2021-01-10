package com.example.gradetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {

    private List<AssessmentType> assessmentTypes;

    public CourseRecyclerAdapter(List<AssessmentType> assessmentTypes) {
        this.assessmentTypes = assessmentTypes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.each_parent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AssessmentType assessmentType = assessmentTypes.get(position);
        String typeName = assessmentType.getBe().getTypeOfAssessment();
        String weighting = Double.toString(assessmentType.getBe().getWeight());
        List<Assessment> assessments = assessmentType.getAssessmentList();

        holder.assessmentTypeName.setText(typeName);
        holder.weighting.setText(weighting);

        ChildRecyclerAdapter childRecyclerAdapter = new ChildRecyclerAdapter(assessments);
        holder.childRecyclerView.setAdapter(childRecyclerAdapter);

    }

    @Override
    public int getItemCount() {
        return assessmentTypes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView assessmentTypeName;
        TextView weighting;
        RecyclerView childRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            assessmentTypeName = itemView.findViewById(R.id.type);
            weighting = itemView.findViewById(R.id.weighting);
            childRecyclerView = itemView.findViewById(R.id.child_recycler_view);
        }
    }
}
