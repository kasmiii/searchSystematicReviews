package com.search.searchreviews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private String document_uri;
    private String id;
    private String title;
    private String journal;
    private ArrayList<String> authors;
    @JsonProperty("abstract")
    private String abstractReview;
    private int year;
    private String classification;
    private ExternalLinks external_links;

    public Result() {
    }

    public String getDocument_uri() {
        return document_uri;
    }

    public void setDocument_uri(String document_uri) {
        this.document_uri = document_uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getAbstractReview() {
        return abstractReview;
    }

    public void setAbstractReview(String abstractReview) {
        this.abstractReview = abstractReview;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ExternalLinks getExternal_links() {
        return external_links;
    }

    public void setExternal_links(ExternalLinks external_links) {
        this.external_links = external_links;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Result{" +
                "document_uri='" + document_uri + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", journal='" + journal + '\'' +
                ", authors=" + authors +
                ", abstractReview='" + abstractReview + '\'' +
                ", year=" + year +
                '}';
    }
}
