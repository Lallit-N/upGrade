package com.example.gradetracker;

import java.util.List;

public class AssessmentType {

    private BreakdownEntry be;
    private List<Assessment> assessmentList;

    public AssessmentType(BreakdownEntry be, List<Assessment> assessmentList) {
        this.be = be;
        this.assessmentList = assessmentList;
    }

    public BreakdownEntry getBe() {
        return be;
    }

    public void setBe(BreakdownEntry be) {
        this.be = be;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

}
