package com.search.searchreviews.repositories;

import com.search.searchreviews.entities.Searcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SearcherRepo extends JpaRepository<Searcher,String> {

    @Query("select s from Searcher s where s.email=?1 and s.password=?2 ")
    Searcher getSearcherByUsernameAndPassword(String username,String password);


}
