package com.search.searchreviews.contollers;

import com.search.searchreviews.model.ResponseNormalSearch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class Search {

    private RestTemplate restTemplate;

    public RestTemplate SpringbootConsumeRestExampleApplication() {
        return new RestTemplate();
    }

    @GetMapping(path = "/reviews")
    @ResponseBody
    public ResponseNormalSearch reviewByTag(@RequestParam("keyword")String keyword,@RequestParam("group") String group,@RequestParam("year")int year){
        restTemplate=SpringbootConsumeRestExampleApplication();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Token token=129c7c0036304e2b8c7b046200256dbd");
        String url="https://api.epistemonikos.org/v1/documents/search?q="+keyword+"&classification=systematic-review&show=external_links";

        if(!group.equals("")){
            url+="&group="+group;
        }
        if(year!=0){
            url+="year="+year;
        }
        //
        HttpEntity entity=new HttpEntity(headers);

        //Map<String,String> params=new HashMap<>();

        //params.put("q",keyword);
        //params.put("classification","systematic-review");
        //params.put("sort",sort);
        //params.put("show","external_links");

        ResponseEntity<ResponseNormalSearch> response=restTemplate.exchange(url, HttpMethod.GET, entity, ResponseNormalSearch.class);
        //System.out.println("total search results"+response.getBody().getSearch_info().getTotal_hits());
        return response.getBody();
    }
}
