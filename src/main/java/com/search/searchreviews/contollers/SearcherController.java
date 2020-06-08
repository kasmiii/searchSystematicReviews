package com.search.searchreviews.contollers;

import com.search.searchreviews.entities.Relevance;
import com.search.searchreviews.entities.Searcher;
import com.search.searchreviews.model.RelevantReview;
import com.search.searchreviews.model.ResponseNormalSearch;
import com.search.searchreviews.repositories.PrelevenceRepo;
import com.search.searchreviews.repositories.SearcherRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SearcherController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SearcherRepo searcherRepo;

    @Autowired
    PrelevenceRepo relevanceRepo;

    private RestTemplate restTemplate;

    public RestTemplate SpringbootConsumeRestExampleApplication() {
        return new RestTemplate();
    }

    @PostMapping(path = "/signup")
    @Transactional
    public Searcher saveSearcher(@RequestBody Searcher searcher){
        entityManager.persist(searcher);
        return searcher;
    }

    @PostMapping(path = "/signin")
    public Searcher getSearcher(@RequestBody Searcher searcher){
        Searcher searcherSession=searcherRepo.getSearcherByUsernameAndPassword(searcher.getEmail(),searcher.getPassword());
        return searcherSession;
    }

    @PostMapping(path = "/relevance")
    @Transactional
    public Relevance savePrevelence(@RequestBody Relevance relevance){
        System.out.println("relevance:  "+relevance);
        entityManager.persist(relevance);
        return relevance;
    }

    @GetMapping(path = "/mostrelevant")
    public ArrayList<RelevantReview> findMostRelevantByKeyword(@RequestParam("keyword")String keyword){

        List<String> list_reviews=relevanceRepo.getRelevantReviewsByKeyword(keyword);
        ArrayList<RelevantReview> mostRelevant=new ArrayList<>();
        restTemplate=SpringbootConsumeRestExampleApplication();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Token token=129c7c0036304e2b8c7b046200256dbd");
        HttpEntity entity=new HttpEntity(headers);
        //getting informations for the list of reviews

        for (String review_id:list_reviews){
            String url="https://api.epistemonikos.org/v1/documents/"+review_id;
            ResponseEntity<RelevantReview> response=restTemplate.exchange(url, HttpMethod.GET, entity, RelevantReview.class);
            mostRelevant.add(response.getBody());
            System.out.println(response.getBody());
        }
        return mostRelevant;
    }
}
