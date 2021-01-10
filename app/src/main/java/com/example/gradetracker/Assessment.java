package com.example.gradetracker;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Assessment implements Serializable {

    private String name;
    private double grade;
    private BreakdownEntry breakdownEntry;


    public Assessment(String name, double grade, BreakdownEntry breakdownEntry) {
        this.name = name;
        this.grade = grade;
        this.breakdownEntry = breakdownEntry;
    }

    protected Assessment(Parcel in) {
        name = in.readString();
        grade = in.readDouble();
        breakdownEntry = in.readParcelable(BreakdownEntry.class.getClassLoader());
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
