package com.search.searchreviews.contollers;

import com.search.searchreviews.model.ResponseNormalSearch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Search {

    private RestTemplate restTemplate;

    public RestTemplate SpringbootConsumeRestExampleApplication() {
        return new RestTemplate();
    }

    @GetMapping(path = "/reviews/{tag}/{classification}/{sort}")
    @ResponseBody
    public ResponseNormalSearch reviewByTag(@PathVariable("tag")String tag,@PathVariable("classification")String classification,@PathVariable("sort")String sort){
        restTemplate=SpringbootConsumeRestExampleApplication();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Token token=129c7c0036304e2b8c7b046200256dbd");
        String url="https://api.epistemonikos.org/v1/documents/search?q={tag}&classification={classification}&sort={sort}&show=external_links";
        HttpEntity entity=new HttpEntity(headers);

        Map<String,String> params=new HashMap<>();

        params.put("tag",tag);
        params.put("classification",classification);
        params.put("sort",sort);

        ResponseEntity<ResponseNormalSearch> response=restTemplate.exchange(url, HttpMethod.GET, entity, ResponseNormalSearch.class,params);
        //System.out.println("total search results"+response.getBody().getSearch_info().getTotal_hits());
        return response.getBody();
    }
}
