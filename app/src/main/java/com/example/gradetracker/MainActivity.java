package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

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
    }
}