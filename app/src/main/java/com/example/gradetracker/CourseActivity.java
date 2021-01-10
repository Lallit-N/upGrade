package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;

public class CourseActivity extends AppCompatActivity {

    private EditText courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();
        Course course = intent.getParcelableExtra("Course");
        System.out.println(course.getName());

        Map<>



    }
}