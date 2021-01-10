package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private List<AssessmentType> assessmentTypes;
    private RecyclerView parentRecyclerView;
    private EditText courseName;
    private Course course;

    private Button addAssessmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        initData();

        parentRecyclerView = findViewById(R.id.parent_recycler_view);
        CourseRecyclerAdapter courseRecyclerAdapter = new CourseRecyclerAdapter(assessmentTypes);
        parentRecyclerView.setAdapter(courseRecyclerAdapter);
        parentRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void initData() {
        course = (Course) getIntent().getSerializableExtra("Course");
        assessmentTypes = new ArrayList<AssessmentType>();

        for (BreakdownEntry be : course.getGradeBreakdown()) {
            if (course.getAssessments().containsKey(be)) {
                assessmentTypes.add(new AssessmentType(be, course.getAssessments().get(be)));
            } else {
                assessmentTypes.add(new AssessmentType(be, new ArrayList<Assessment>()));
            }
        }
    }


}