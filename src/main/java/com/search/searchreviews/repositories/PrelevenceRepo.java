package com.search.searchreviews.repositories;

import com.search.searchreviews.entities.Relevance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrelevenceRepo extends JpaRepository<Relevance,String> {

    @Query(value = "select p from Relevance p where p.id=?1 ")
    Relevance getById(String id);

    //select id_review_slr from relevance where keyword like '%tam%' group by id_review_slr order by count(keyword) desc;

    @Query("select r.id_review_slr from Relevance r where r.keyword like %:keyword% group by r.id_review_slr order by count(r.keyword) desc")
    List<String> getRelevantReviewsByKeyword(@Param("keyword")String keyword);

}
