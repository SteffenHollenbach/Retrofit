package com.example.steffen.test2;

/**
 * Created by Steffen on 23.07.2015.
 */
public class Task {

    private String title;
    private String description;

    public String getDescription() {
        return description;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){ return "Title: " + this.getTitle() + ", Description: " + this.getDescription();}
}
