package com.example.gradetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course {

    private String name;
    private double grade;
    private GradeBreakdown gradeBreakdown;
    private HashMap<String, List<Assessment>> assessments;


    public Course(String name, GradeBreakdown gb) {
        this.name = name;
        gradeBreakdown = gb;
        assessments = new HashMap<String, List<Assessment>>();
    }

    public String getName() {
        return name;
    }

    public GradeBreakdown getGradeBreakdown() {
        return gradeBreakdown;
    }

    public HashMap<String, List<Assessment>> getAssessments() {
        return assessments;
    }

    public void addAssessment(Assessment assessment) {
        if (assessments.containsKey(assessment.getTypeOfAssessment())) {
            assessments.get(assessment.getTypeOfAssessment()).add(assessment);
        } else {
            List<Assessment> newList = new ArrayList<Assessment>();
            newList.add(assessment);
            assessments.put(assessment.getTypeOfAssessment(), newList);
        }
    }

    public void removeAssessment(Assessment assessment) {
        assessments.get(assessment.getTypeOfAssessment()).remove(assessment);
    }

    public double getCurrentGrade() {
        return 0; // stub
    }

    public double getMinGrade() {

        return 0; // stub
    }

    public double getMaxGrade() {

        return 0; // stub
    }

}
