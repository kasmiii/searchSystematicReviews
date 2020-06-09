package com.search.searchreviews.contollers;

import com.search.searchreviews.model.RequestParams;
import com.search.searchreviews.model.ResponseNormalSearch;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@CrossOrigin(origins = "*")
public class Search {

    private RestTemplate restTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public RestTemplate SpringbootConsumeRestExampleApplication() {
        return new RestTemplate();
    }

    @GetMapping(path = "/reviews")
    @ResponseBody
    public ResponseNormalSearch reviewByTag(@RequestParam("keyword")String keyword,@RequestParam("group") String group,@RequestParam("year")int year,@RequestParam("page")int page){
        restTemplate=SpringbootConsumeRestExampleApplication();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Token token=129c7c0036304e2b8c7b046200256dbd");
        String url="https://api.epistemonikos.org/v1/documents/search?q="+keyword+"&classification=systematic-review&show=external_links&p="+page;
        System.out.println("la page recherche est :\t\t\t"+page);
        if(!group.equals("")){
            url+="&group="+group;
        }
        if(year!=0){
            url+="&year="+year;
        }
        HttpEntity entity=new HttpEntity(headers);
        ResponseEntity<ResponseNormalSearch> response=restTemplate.exchange(url, HttpMethod.GET, entity, ResponseNormalSearch.class);
        System.out.println("total search results for page:"+page+"is:"+response.getBody());
        return response.getBody();
    }

    @PostMapping(path = "/advanccedsearch")
    @ResponseBody
    public ResponseNormalSearch postAdvancedReviews(@RequestBody RequestParams requestParam){
        restTemplate=SpringbootConsumeRestExampleApplication();
        System.out.println(requestParam);
        RequestParams requestParams=requestParam;
        String url="https://api.epistemonikos.org/v1/documents/advanced_search";
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Token token=129c7c0036304e2b8c7b046200256dbd");
        JSONObject personJsonObject = new JSONObject();

        personJsonObject.put("query",requestParam.getKeyword());
        personJsonObject.put("only_reviews",true);

        if(requestParam.getMin_year()!=0){
            personJsonObject.put("min_year",requestParam.getMin_year());
        }
        if(requestParam.getMax_year()!=0){
            personJsonObject.put("max_year",requestParam.getMax_year());
        }

        HttpEntity<String> request =
                new HttpEntity<String>(personJsonObject.toString(), headers);

        //ResponseNormalSearch responseNormalSearch=restTemplate.postForObject(url,request,ResponseNormalSearch.class);
        ResponseEntity<ResponseNormalSearch> responseNormalSearch=restTemplate.exchange(url, HttpMethod.POST, request, ResponseNormalSearch.class);
        return responseNormalSearch.getBody();
    }

}
