package com.search.searchreviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalLinks {

    private String publisher;
    private String epistemonikos;
    private String pubmed;

    public ExternalLinks() {
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEpistemonikos() {
        return epistemonikos;
    }

    public void setEpistemonikos(String epistemonikos) {
        this.epistemonikos = epistemonikos;
    }

    public String getPubmed() {
        return pubmed;
    }

    public void setPubmed(String pubmed) {
        this.pubmed = pubmed;
    }

    @Override
    public String toString() {
        return "ExternalLinks{" +
                "publisher='" + publisher + '\'' +
                ", epistemonikos='" + epistemonikos + '\'' +
                ", pubmed='" + pubmed + '\'' +
                '}';
    }

}
