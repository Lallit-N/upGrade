package com.example.gradetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CourseActivity extends AppCompatActivity implements AddAssessmentDialog.AddAssessmentListener {

    TextView currentGrade;
    TextView minGrade;
    TextView maxGrade;
    TextView courseName;

    private List<AssessmentType> assessmentTypes;
    private RecyclerView parentRecyclerView;
    private CourseRecyclerAdapter courseRecyclerAdapter;
    private Course course;

    private Button addAssessmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        initData();

        parentRecyclerView = findViewById(R.id.parent_recycler_view);
        courseRecyclerAdapter = new CourseRecyclerAdapter(assessmentTypes);
        parentRecyclerView.setAdapter(courseRecyclerAdapter);
        parentRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        currentGrade = (TextView) findViewById(R.id.current_grade);
        currentGrade.setText(course.getCurrentGrade());

        minGrade = (TextView) findViewById(R.id.min_grade);
        minGrade.setText(course.getMinGrade());

        maxGrade = (TextView) findViewById(R.id.max_grade);
        maxGrade.setText(course.getMaxGrade());

        courseName = (TextView) findViewById(R.id.course_name_2);
        courseName.setText(course.getName());

        addAssessmentButton = (Button) findViewById(R.id.add_assessment_button);
        addAssessmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    public void openDialog() {
        AddAssessmentDialog aad = new AddAssessmentDialog();
        aad.show(getSupportFragmentManager(), "Add Assessment");
    }

    @Override
    public void applyTexts2(String a, String g, String be) {
        Assessment assessment = null;
        for (BreakdownEntry b : course.getGradeBreakdown()) {
            if (b.getTypeOfAssessment().equals(be)) {
                assessment = new Assessment(a, parseDouble(g), b);
            }
        }
        course.addAssessment(assessment);
        courseRecyclerAdapter.notifyDataSetChanged();
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