package com.search.searchreviews.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

    private String title;
    @JsonProperty("abstract")
    private String abstract_review;
    private int year;
    private ArrayList<String> authors;

    public Content() {
    }

    public Content(String title, String abstract_review, int year, ArrayList<String> authors) {
        this.title = title;
        this.abstract_review = abstract_review;
        this.year = year;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract_review() {
        return abstract_review;
    }

    public void setAbstract_review(String abstract_review) {
        this.abstract_review = abstract_review;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", abstract_review='" + abstract_review + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
