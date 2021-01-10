package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button addCourseButton;

    ArrayList<Course> courseList = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        HashSet<BreakdownEntry> breakdownEntries = new HashSet<BreakdownEntry>();
        breakdownEntries.add(new BreakdownEntry("yes", 20, 2));

        courseList.add(new Course("CPSC 221", new GradeBreakdown(breakdownEntries)));
        courseList.add(new Course("CPSC 213", new GradeBreakdown(breakdownEntries)));
        courseList.add(new Course("MATH 221", new GradeBreakdown(breakdownEntries)));
        courseList.add(new Course("PSYC 102", new GradeBreakdown(breakdownEntries)));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CourseAdapter(this, courseList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        addCourseButton = (Button) findViewById(R.id.add_course_button);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        AddCourseDialog acd = new AddCourseDialog();
        acd.show(getSupportFragmentManager(), "Add Course");
    }

}