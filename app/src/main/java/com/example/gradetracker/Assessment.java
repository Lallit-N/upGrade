package com.example.gradetracker;

import android.os.Parcel;
import android.os.Parcelable;

public class Assessment implements Parcelable {

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

    public static final Creator<Assessment> CREATOR = new Creator<Assessment>() {
        @Override
        public Assessment createFromParcel(Parcel in) {
            return new Assessment(in);
        }

        @Override
        public Assessment[] newArray(int size) {
            return new Assessment[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public BreakdownEntry getBreakdownEntry() {
        return breakdownEntry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(grade);
        dest.writeParcelable(breakdownEntry, flags);
    }
}
