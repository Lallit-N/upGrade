package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;

public class CourseActivity extends AppCompatActivity {

    private EditText courseName;
    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        course = (Course) getIntent().getSerializableExtra("Course");
    }

    private void initData() {
        //course.getAssessments().
    }


}