package com.example.gradetracker;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

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

    protected BreakdownEntry(Parcel in) {
        typeOfAssessment = in.readString();
        weight = in.readDouble();
        totalNumAssessments = in.readDouble();
        numAssessmentsLeft = in.readDouble();
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
