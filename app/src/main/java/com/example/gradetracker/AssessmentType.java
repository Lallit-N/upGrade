package com.example.gradetracker;

import java.util.List;

public class AssessmentType {

    private String assessmentTypeName;
    private List<Assessment> assessmentList;

    public AssessmentType(String assessmentTypeName, List<Assessment> assessmentList) {
        this.assessmentTypeName = assessmentTypeName;
        this.assessmentList = assessmentList;
    }

    public String getAssessmentTypeName() {
        return assessmentTypeName;
    }

    public void setAssessmentTypeName(String assessmentTypeName) {
        this.assessmentTypeName = assessmentTypeName;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    @Override
    public String toString() {
        return "AssessmentType{" +
                "assessmentTypeName='" + assessmentTypeName + '\'' +
                ", assessmentList=" + assessmentList +
                '}';
    }
}
