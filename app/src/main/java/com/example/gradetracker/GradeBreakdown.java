package com.example.gradetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradeBreakdown {

    private HashMap<String, List<Assessment>> assessments;


    public GradeBreakdown() {
        assessments = new HashMap<String, List<Assessment>>();
    }

    public void addAssessment(Assessment assessment) {
        if (assessments.containsKey(assessment.getTypeOfAssessment())) {
            assessments.get(assessment.getTypeOfAssessment()).add(assessment);
        } else {
            List<Assessment> newList = new ArrayList<Assessment>();
            newList.add(assessment);
            assessments.put(assessment.getTypeOfAssessment(), newList);
        }
    }

    public void removeAssessment(Assessment assessment) {
        assessments.get(assessment.getTypeOfAssessment()).remove(assessment);
    }
}
