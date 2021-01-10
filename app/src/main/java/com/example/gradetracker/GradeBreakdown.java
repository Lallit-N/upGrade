package com.example.gradetracker;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GradeBreakdown implements Iterable<BreakdownEntry> {

    private double marksAvailable;
    private Set<BreakdownEntry> gradeBreakdown;


    public GradeBreakdown(HashSet<BreakdownEntry> gradeBreakdown) {
        this.gradeBreakdown = gradeBreakdown;
        marksAvailable = 100;
    }

    public Set<BreakdownEntry> getGBreakdown() {
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
