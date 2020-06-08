package com.search.searchreviews.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelevantReview {
    private String id;
    private String citation;
    private ExternalLinks external_links;
    private Identifiers identifiers;
    private Content content;

    public RelevantReview() {
    }

    public RelevantReview(String id, String citation, ExternalLinks external_links, Identifiers identifiers, Content content) {
        this.id = id;
        this.citation = citation;
        this.external_links = external_links;
        this.identifiers = identifiers;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public ExternalLinks getExternal_links() {
        return external_links;
    }

    public void setExternal_links(ExternalLinks external_links) {
        this.external_links = external_links;
    }

    public Identifiers getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RelevantReview{" +
                "id='" + id + '\'' +
                ", citation='" + citation + '\'' +
                ", external_links=" + external_links +
                ", identifiers=" + identifiers +
                ", content=" + content +
                '}';
    }
}
