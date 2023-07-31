package com.example.careerapp.model;

public class examModel {
    private String examName,examEligibility,examDate,examWebsite,examLogo,examDescription;

    public examModel() {
    }

    public examModel(String examName, String examEligibility, String examDate, String examWebsite, String examLogo, String examDescription) {
        this.examName = examName;
        this.examEligibility = examEligibility;
        this.examDate = examDate;
        this.examWebsite = examWebsite;
        this.examLogo = examLogo;
        this.examDescription = examDescription;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public String getExamName() {
        return examName;
    }

    public String getExamEligibility() {
        return examEligibility;
    }

    public String getExamDate() {
        return examDate;
    }

    public String getExamWebsite() {
        return examWebsite;
    }

    public String getExamLogo() {
        return examLogo;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setExamEligibility(String examEligibility) {
        this.examEligibility = examEligibility;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public void setExamWebsite(String examWebsite) {
        this.examWebsite = examWebsite;
    }

    public void setExamLogo(String examLogo) {
        this.examLogo = examLogo;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }
}
