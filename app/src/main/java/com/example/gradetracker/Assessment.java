package com.example.gradetracker;

public class Assessment {

    private String name;
    private double grade;
    private BreakdownEntry breakdownEntry;


    public Assessment(String name, double grade, BreakdownEntry breakdownEntry) {
        this.name = name;
        this.grade = grade;
        this.breakdownEntry = breakdownEntry;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public BreakdownEntry getBreakdownEntry() {
        return breakdownEntry;
    }
}
