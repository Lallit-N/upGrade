package com.example.gradetracker;

public class Assessment {

    private String name;
    private double grade;
    private String typeOfAssessment;


    public Assessment(String name, double grade, String typeOfAssessment) {
        this.name = name;
        this.grade = grade;
        this.typeOfAssessment = typeOfAssessment;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String getTypeOfAssessment() {
        return typeOfAssessment;
    }
}
