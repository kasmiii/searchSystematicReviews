package com.search.searchreviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifiers {

    private String pubmed;
    private String epistemmonikos;
    private String doi;

    public Identifiers() {
    }

    public Identifiers(String pubmed, String epistemmonikos, String doi) {
        this.pubmed = pubmed;
        this.epistemmonikos = epistemmonikos;
        this.doi = doi;
    }

    public String getPubmed() {
        return pubmed;
    }

    public void setPubmed(String pubmed) {
        this.pubmed = pubmed;
    }

    public String getEpistemmonikos() {
        return epistemmonikos;
    }

    public void setEpistemmonikos(String epistemmonikos) {
        this.epistemmonikos = epistemmonikos;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Override
    public String toString() {
        return "Identifiers{" +
                "pubmed='" + pubmed + '\'' +
                ", epistemmonikos='" + epistemmonikos + '\'' +
                ", doi='" + doi + '\'' +
                '}';
    }

}
