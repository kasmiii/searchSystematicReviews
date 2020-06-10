package com.search.searchreviews.model;

public class RequestParams {

    public String keyword;
    public int min_year;
    public int max_year;
    public  String exclude_cochrane;

    public RequestParams() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getMin_year() {
        return min_year;
    }

    public void setMin_year(int min_year) {
        this.min_year = min_year;
    }

    public int getMax_year() {
        return max_year;
    }

    public void setMax_year(int max_year) {
        this.max_year = max_year;
    }

    public String getExclude_cochrane() {
        return exclude_cochrane;
    }

    public void setExclude_cochrane(String exclude_cochrane) {
        this.exclude_cochrane = exclude_cochrane;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "keyword='" + keyword + '\'' +
                ", min_year=" + min_year +
                ", max_year=" + max_year +
                ",exclude_cochrane=" +exclude_cochrane+
                '}';
    }
}
