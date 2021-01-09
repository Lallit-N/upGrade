package com.example.gradetracker;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GradeBreakdown implements Iterable<BreakdownEntry> {

    private double marksAvailable;
    private Set<BreakdownEntry> gBreakdown;


    public GradeBreakdown() {
        gBreakdown = new HashSet<BreakdownEntry>();
        marksAvailable = 100;
    }

    public Set<BreakdownEntry> getGBreakdown() {
        return gBreakdown;
    }

    public double getMarksAvailable() {
        return marksAvailable;
    }

    public void addBreakdownEntry(BreakdownEntry be) {
        gBreakdown.add(be);
        marksAvailable -= be.getWeighting();
    }

    public void removeBreakdownEntry(BreakdownEntry be) {
        gBreakdown.remove(be);
        marksAvailable += be.getWeighting();
    }

    @NonNull
    @Override
    public Iterator<BreakdownEntry> iterator() {
        return gBreakdown.iterator();
    }
}
