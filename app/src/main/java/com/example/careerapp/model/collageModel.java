package com.example.careerapp.model;

public class collageModel {

    private String clgName,clgLocation,clgWebsite,clgPic,clgLogo,clgDescription,clg_Rating;

    public collageModel(){

    }

    public collageModel(String clgName, String clgLocation, String clgWebsite, String clgPic, String clgLogo, String clgDescription, String clg_Rating) {
        this.clgName = clgName;
        this.clgLocation = clgLocation;
        this.clgWebsite = clgWebsite;
        this.clgPic = clgPic;
        this.clgLogo = clgLogo;
        this.clgDescription = clgDescription;
        this.clg_Rating = clg_Rating;
    }

    public String getClg_Rating() {
        return clg_Rating;
    }

    public String getClgDescription() {
        return clgDescription;
    }

    public String getClgName() {
        return clgName;
    }

    public String getClgLocation() {
        return clgLocation;
    }

    public String getClgWebsite() {
        return clgWebsite;
    }

    public String getClgPic() {
        return clgPic;
    }

    public String getClgLogo() {
        return clgLogo;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public void setClgLocation(String clgLocation) {
        this.clgLocation = clgLocation;
    }

    public void setClgWebsite(String clgWebsite) {
        this.clgWebsite = clgWebsite;
    }

    public void setClgPic(String clgPic) {
        this.clgPic = clgPic;
    }

    public void setClgLogo(String clgLogo) {
        this.clgLogo = clgLogo;
    }

    public void setClgDescription(String clgDescription) {
        this.clgDescription = clgDescription;
    }

    public void setClg_Rating(String clg_Rating) {
        this.clg_Rating = clg_Rating;
    }
}
