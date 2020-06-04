package com.search.searchreviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchInfo {

    private Pages pages;
    private int total_hits;

    public SearchInfo() {
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public int getTotal_hits() {
        return total_hits;
    }

    public void setTotal_hits(int total_hits) {
        this.total_hits = total_hits;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "pages=" + pages +
                ", total_hits=" + total_hits +
                '}';
    }
}
