package com.example.gradetracker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GradeBreakdown implements Iterable<BreakdownEntry>, Serializable {

    private double marksAvailable;
    private List<BreakdownEntry> gradeBreakdown;


    public GradeBreakdown(List<BreakdownEntry> gradeBreakdown) {
        this.gradeBreakdown = gradeBreakdown;
        marksAvailable = 100;
    }

    protected GradeBreakdown(Parcel in) {
        marksAvailable = in.readDouble();
    }

    public List<BreakdownEntry> getGBreakdown() {
        return gradeBreakdown;
    }

    public double getMarksAvailable() {
        return marksAvailable;
    }

    public void addBreakdownEntry(BreakdownEntry be) {
        gradeBreakdown.add(be);
        marksAvailable -= be.getWeight();
    }

    public void removeBreakdownEntry(BreakdownEntry be) {
        gradeBreakdown.remove(be);
        marksAvailable += be.getWeight();
    }

    @NonNull
    @Override
    public Iterator<BreakdownEntry> iterator() {
        return gradeBreakdown.iterator();
    }

}
