package com.example.careerapp;

public class ExampleItem {
    private String courseName,courseField,courseUrl,courseDescription;

    public ExampleItem(String courseName, String courseField, String courseUrl, String courseDescription) {
        this.courseName = courseName;
        this.courseField = courseField;
        this.courseUrl = courseUrl;
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseField() {
        return courseField;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public String getCourseDescription() {
        return courseDescription;
    }
}