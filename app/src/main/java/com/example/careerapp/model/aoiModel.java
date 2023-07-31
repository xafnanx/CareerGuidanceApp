package com.example.careerapp.model;

public class aoiModel {
    private String careerName,careerDescription,careerUrl,careerStream,careerSubject,careerDifficulty;

    public aoiModel(String careerName, String careerDescription, String careerUrl, String careerStream, String careerSubject, String careerDifficulty) {
        this.careerName = careerName;
        this.careerDescription = careerDescription;
        this.careerUrl = careerUrl;
        this.careerStream = careerStream;
        this.careerSubject = careerSubject;
        this.careerDifficulty = careerDifficulty;
    }

    public String getCareerName() {
        return careerName;
    }

    public String getCareerDescription() {
        return careerDescription;
    }

    public String getCareerUrl() {
        return careerUrl;
    }

    public String getCareerStream() {
        return careerStream;
    }

    public String getCareerSubject() {
        return careerSubject;
    }

    public String getCareerDifficulty() {
        return careerDifficulty;
    }
}