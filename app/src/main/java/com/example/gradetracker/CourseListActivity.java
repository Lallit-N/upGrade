package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CourseListActivity extends AppCompatActivity implements AddCourseDialog.AddCourseListener, CourseListRecyclerAdapter.OnCourseListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button addCourseButton;

    ArrayList<Course> mCourses = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Set<BreakdownEntry> breakdownEntries = new HashSet<BreakdownEntry>();
        breakdownEntries.add(new BreakdownEntry("yes", 20, 2));

        Course course1 = new Course("CPSC 221", new GradeBreakdown(breakdownEntries));

        mCourses.add(course1);
        mCourses.add(new Course("CPSC 213", new GradeBreakdown(breakdownEntries)));
        mCourses.add(new Course("MATH 221", new GradeBreakdown(breakdownEntries)));
        mCourses.add(new Course("PSYC 102", new GradeBreakdown(breakdownEntries)));

        course1.addAssessment(new Assessment("test", 69, new BreakdownEntry("yes", 20, 2)));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CourseListRecyclerAdapter(this, mCourses, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        addCourseButton = (Button) findViewById(R.id.add_course_button);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        //---------------------------
        BreakdownEntry be1 = new BreakdownEntry("yes", 20, 2);
        BreakdownEntry be2 = new BreakdownEntry("hello", 30, 2);
        Set<BreakdownEntry> breakdownEntrySet = new HashSet<>();
        breakdownEntrySet.add(be1);
        breakdownEntrySet.add(be2);
        GradeBreakdown gb = new GradeBreakdown(breakdownEntrySet);
        Course test = new Course("test", gb);
        mCourses.add(test);
        test.addAssessment(new Assessment("math", 100, be1));
        test.addAssessment(new Assessment("science", 100, be2));
        test.addAssessment(new Assessment("geo", 100, be1));

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

        Set<BreakdownEntry> beList = new HashSet<>();

        if (!c1.equals("")) {
            BreakdownEntry be1 = new BreakdownEntry(c1, parseDouble(w1), parseInt(a1));
            beList.add(be1);
        }
        if (!c2.equals("")) {
            BreakdownEntry be2 = new BreakdownEntry(c2, parseDouble(w2), parseInt(a2));
            beList.add(be2);
        }
        if (!c3.equals("")) {
            BreakdownEntry be3 = new BreakdownEntry(c3, parseDouble(w3), parseInt(a3));
            beList.add(be3);
        }
        if (!c4.equals("")) {
            BreakdownEntry be4 = new BreakdownEntry(c4, parseDouble(w4), parseInt(a4));
            beList.add(be4);
        }
        if (!c5.equals("")) {
            BreakdownEntry be5 = new BreakdownEntry(c5, parseDouble(w5), parseInt(a5));
            beList.add(be5);
        }
        if (!c6.equals("")) {
            BreakdownEntry be6 = new BreakdownEntry(c6, parseDouble(w6), parseInt(a6));
            beList.add(be6);
        }
        if (!c7.equals("")) {
            BreakdownEntry be7 = new BreakdownEntry(c7, parseDouble(w7), parseInt(a7));
            beList.add(be7);
        }
        if (!c8.equals("")) {
            BreakdownEntry be8 = new BreakdownEntry(c8, parseDouble(w8), parseInt(a8));
            beList.add(be8);
        }

        GradeBreakdown gb = new GradeBreakdown(beList);

        mCourses.add(new Course(name, gb));

    }

    @Override
    public void onCourseClick(int position) {
        Intent intent = new Intent(this, CourseActivity.class);
        intent.putExtra("Course", mCourses.get(position));
        startActivity(intent);
    }
}