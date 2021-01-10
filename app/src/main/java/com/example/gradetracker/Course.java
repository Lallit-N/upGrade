package com.example.gradetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

    private String name;
    private double currentGrade;
    private double minGrade;
    private double maxGrade;
    private GradeBreakdown gradeBreakdown;
    private Map<BreakdownEntry, List<Assessment>> assessments;


    public Course(String name, GradeBreakdown gb) {
        this.name = name;
        gradeBreakdown = gb;
        assessments = new HashMap<BreakdownEntry, List<Assessment>>();
        currentGrade = 0;
        minGrade = 0;
        maxGrade = 0;
    }

    public String getName() {
        return name;
    }

    public GradeBreakdown getGradeBreakdown() {
        return gradeBreakdown;
    }

    public Map<BreakdownEntry, List<Assessment>> getAssessments() {
        return assessments;
    }

    public void addAssessment(Assessment assessment) {
        if (assessments.containsKey(assessment.getBreakdownEntry())) {
            assessments.get(assessment.getBreakdownEntry()).add(assessment);
            assessment.getBreakdownEntry().addAssessment();
        } else {
            List<Assessment> tempList = new ArrayList<Assessment>();
            tempList.add(assessment);
            assessments.put(assessment.getBreakdownEntry(), tempList);
            assessment.getBreakdownEntry().addAssessment();
        }
    }

    public void removeAssessment(Assessment assessment) {
        assessments.get(assessment.getBreakdownEntry()).remove(assessment);
        assessment.getBreakdownEntry().removeAssessment();
    }

    public String getCurrentGrade() {
        currentGrade = 0;
        double intermediateVal;
        double totalOutOf = 0;
        for (BreakdownEntry b : gradeBreakdown) {
            intermediateVal = 0;
            if (assessments.containsKey(b)) {
                for (Assessment a : assessments.get(b)) {
                    intermediateVal += a.getGrade() / assessments.get(b).size();
                }
                currentGrade += intermediateVal * b.getWeight();
                totalOutOf += b.getWeight();
            }
        }
        if (totalOutOf != 0) {
            currentGrade = currentGrade / totalOutOf;
        }
        return Double.toString(currentGrade) + "%";
    }

    public String getMinGrade() {
        minGrade = 0;
        double intermediateVal;
        double totalOutOf = 0;
        for (BreakdownEntry b : gradeBreakdown) {
            intermediateVal = 0;
            if (assessments.containsKey(b)) {
                for (Assessment a : assessments.get(b)) {
                    intermediateVal += a.getGrade() / b.getTotalNumAssessments();
                }
            }
            minGrade += intermediateVal * b.getWeight();
            totalOutOf += b.getWeight();
        }
        if (totalOutOf != 0) {
            minGrade = minGrade / totalOutOf;
        }
        return Double.toString(minGrade) + "%";
    }

    public String getMaxGrade() {
        maxGrade = 0;
        double intermediateVal;
        double totalOutOf = 0;
        for (BreakdownEntry b : gradeBreakdown) {
            intermediateVal = 0;
            if (assessments.containsKey(b)) {
                for (Assessment a : assessments.get(b)) {
                    intermediateVal += a.getGrade() / b.getTotalNumAssessments();
                    intermediateVal += b.getNumAssessmentsLeft() * 100 / b.getTotalNumAssessments();
                }
            } else {
                intermediateVal = 100;
            }
            maxGrade += intermediateVal * b.getWeight();
            totalOutOf += b.getWeight();
        }
        if (totalOutOf != 0) {
            maxGrade = maxGrade / totalOutOf;
        }
        return Double.toString(maxGrade) + "%";
    }
}
