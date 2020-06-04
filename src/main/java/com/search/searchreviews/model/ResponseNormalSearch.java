package com.search.searchreviews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseNormalSearch {

    private SearchInfo search_info;
    private ArrayList<Result> results;

    public ResponseNormalSearch() { }

    public SearchInfo getSearch_info() {
        return search_info;
    }

    public void setSearch_info(SearchInfo search_info) {
        this.search_info = search_info;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResponseNormalSearch{" +
                "search_info=" + search_info +
                ", results=" + results +
                '}';
    }
}
