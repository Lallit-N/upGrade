package com.example.gradetracker;

import android.os.Parcel;
import android.os.Parcelable;

public class BreakdownEntry implements Parcelable {

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

    public static final Creator<BreakdownEntry> CREATOR = new Creator<BreakdownEntry>() {
        @Override
        public BreakdownEntry createFromParcel(Parcel in) {
            return new BreakdownEntry(in);
        }

        @Override
        public BreakdownEntry[] newArray(int size) {
            return new BreakdownEntry[size];
        }
    };

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(typeOfAssessment);
        dest.writeDouble(weight);
        dest.writeDouble(totalNumAssessments);
        dest.writeDouble(numAssessmentsLeft);
    }
}
