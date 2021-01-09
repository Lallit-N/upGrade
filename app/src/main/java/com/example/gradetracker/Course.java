package com.example.gradetracker;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private String name;
    private double currentGrade;
    private double minGrade;
    private double maxGrade;
    private GradeBreakdown gradeBreakdown;
    private Set<Assessment> assessments;


    public Course(String name, GradeBreakdown gb) {
        this.name = name;
        gradeBreakdown = gb;
        assessments = new HashSet<Assessment>();
    }

    public String getName() {
        return name;
    }

    public GradeBreakdown getGradeBreakdown() {
        return gradeBreakdown;
    }

    public Set<Assessment> getAssessments() {
        return assessments;
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
        assessment.getBreakdownEntry().addAssessment();
    }

    public void removeAssessment(Assessment assessment) {
        assessments.remove(assessment);
        assessment.getBreakdownEntry().removeAssessment();
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
