package com.example.socialdemo.data.model;

public class MedicalPojo {

    private String name;
    private String imagePath;

    public MedicalPojo(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
