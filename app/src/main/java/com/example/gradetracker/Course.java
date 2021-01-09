package com.example.gradetracker;

public class Course {

    private String name;
    private double grade;
    private GradeBreakdown gradeBreakdown;


    public Course(String name, GradeBreakdown gb) {
        this.name = name;
        gradeBreakdown = gb;
    }

    public String getName() {
        return name;
    }

    public GradeBreakdown getGradeBreakdown() {
        return gradeBreakdown;
    }

    public double getGrade() {
        return 0; // stub
    }

}
