package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements AddCourseDialog.AddCourseListener {

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


    public void applyTexts(String name, String c1, String w1, String a1,
                           String c2, String w2, String a2,
                           String c3, String w3, String a3,
                           String c4, String w4, String a4,
                           String c5, String w5, String a5,
                           String c6, String w6, String a6,
                           String c7, String w7, String a7,
                           String c8, String w8, String a8) {

        BreakdownEntry be1 = new BreakdownEntry(c1, parseDouble(w1), parseInt(a1));
        BreakdownEntry be2 = new BreakdownEntry(c2, parseDouble(w2), parseInt(a2));
        BreakdownEntry be3 = new BreakdownEntry(c3, parseDouble(w3), parseInt(a3));
        BreakdownEntry be4 = new BreakdownEntry(c4, parseDouble(w4), parseInt(a4));
        BreakdownEntry be5 = new BreakdownEntry(c5, parseDouble(w5), parseInt(a5));
        BreakdownEntry be6 = new BreakdownEntry(c6, parseDouble(w6), parseInt(a6));
        BreakdownEntry be7 = new BreakdownEntry(c7, parseDouble(w7), parseInt(a7));
        BreakdownEntry be8 = new BreakdownEntry(c8, parseDouble(w8), parseInt(a8));

        HashSet<BreakdownEntry> beList = new HashSet<>();

        beList.add(be1);
        beList.add(be2);
        beList.add(be3);
        beList.add(be4);
        beList.add(be5);
        beList.add(be6);
        beList.add(be7);
        beList.add(be8);

        GradeBreakdown gb = new GradeBreakdown(beList);

        courseList.add(new Course(name, gb));

    }
}