package com.example.gradetracker;

import java.io.Serializable;
import java.util.Objects;

public class BreakdownEntry implements Serializable {

    private String typeOfAssessment;
    private double weight;
    private double totalNumAssessments;
    private double numAssessmentsLeft;

    public BreakdownEntry(String typeOfAssessment, double weight, int numAssessments) {
        this.typeOfAssessment = typeOfAssessment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakdownEntry that = (BreakdownEntry) o;
        return Objects.equals(typeOfAssessment, that.typeOfAssessment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfAssessment);
    }
}
