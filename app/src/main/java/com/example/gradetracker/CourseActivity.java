package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;

public class CourseActivity extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private EditText courseName;
    private Course course;

    private Button addAssessmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        recyclerView2 = findViewById(R.id.recyclerView2);

        course = (Course) getIntent().getSerializableExtra("Course");
    }

    private void initData() {
        //course.getAssessments().
    }


    }
}