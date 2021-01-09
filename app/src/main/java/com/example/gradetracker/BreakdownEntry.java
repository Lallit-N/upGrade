package com.example.gradetracker;

public class BreakdownEntry {

    private String typeOfAssessment;
    private double weighting;

    public BreakdownEntry(String name, double weighting) {
        this.typeOfAssessment = name;
        this.weighting = weighting;
    }

    public String getTypeOfAssessment() {
        return typeOfAssessment;
    }

    public double getWeighting() {
        return weighting;
    }
}
