package com.search.searchreviews.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relevance {

    /*
    *  id number,
  3      id_review_slr varchar2(100),
  4      id_user varchar(20),
  5      keyword varchar2(100),
    * */
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "id_review_slr")
    private String id_review_slr;
    @Column(name = "id_user")
    private String id_user;
    @Column(name = "keyword")
    private String keyword;

    public Relevance() {
    }

    public Relevance(String id, String id_review_slr, String id_user, String keyword) {
        this.id = id;
        this.id_review_slr = id_review_slr;
        this.id_user = id_user;
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_review_slr() {
        return id_review_slr;
    }

    public void setId_review_slr(String id_review_slr) {
        this.id_review_slr = id_review_slr;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Prelevence{" +
                "id=" + id +
                ", id_review_slr='" + id_review_slr + '\'' +
                ", id_user='" + id_user + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

}
