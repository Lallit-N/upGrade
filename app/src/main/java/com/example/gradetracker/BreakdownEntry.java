package com.example.gradetracker;

public class BreakdownEntry {

    private String typeOfAssessment;
    private double weight;
    private double totalNumAssessments;
    private double numAssessmentsLeft;

    public BreakdownEntry(String name, double weight, int numAssessments) {
        this.typeOfAssessment = name;
        this.weight = weight;
        this.totalNumAssessments = numAssessments;
        numAssessmentsLeft = numAssessments;
    }

    public String getTypeOfAssessment() {
        return typeOfAssessment;
    }

    public double getWeight() {
        return weight;
    }

    public double getTotalNumAssessments() {
        return totalNumAssessments;
    }

    public double getNumAssessmentsLeft() {
        return numAssessmentsLeft;
    }

    public void addAssessment() {
        numAssessmentsLeft--;
    }

    public void removeAssessment() {
        numAssessmentsLeft++;
    }
}
