package com.example.gradetracker;

public class BreakdownEntry {

    private String typeOfAssessment;
    private double weighting;
    private int totalNumAssessments;

    public BreakdownEntry(String name, double weighting, int numAssessments) {
        this.typeOfAssessment = name;
        this.weighting = weighting;
        this.totalNumAssessments = numAssessments;
    }

    public String getTypeOfAssessment() {
        return typeOfAssessment;
    }

    public double getWeighting() {
        return weighting;
    }

    public int getTotalNumAssessments() {
        return totalNumAssessments;
    }

    public void addAssessment() {
        totalNumAssessments--;
    }

    public void removeAssessment() {
        totalNumAssessments++;
    }
}
