package com.search.searchreviews;

//import com.mashape.unirest.http.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
//import com.sun.deploy.net.HttpResponse;
import com.mashape.unirest.http.HttpResponse;

import java.net.URLEncoder;

public class Test {

    public static String getReviews(String tag) throws Exception{

        // Host url
        String host = "http://api.springernature.com/metadata/json";
        String charset = "UTF-8";
        // Headers for a request
        String x_epistemonikos_host = "api.springernature.com";
        String x_epistemonikos_key = "2a5eb67d832e5501f5043049760f2f93";//Type here your key
        // Params
        String s = tag;
//?q=keyword:onlinear&api_key=..

        String query=String.format("q=keyword:%s&api_key=2a5eb67d832e5501f5043049760f2f93",URLEncoder.encode(s,charset));

        HttpResponse<JsonNode> response = Unirest.get(host + "?" + query)
                .header("x_epistemonikos_host", x_epistemonikos_host)
                .header("x_epistemonikos_key", x_epistemonikos_key)
                .asJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        //System.out.println(prettyJsonString);
        //System.out.println(response.getStatus());
        //System.out.println(response.getHeaders().get("Content-Type"));
        return prettyJsonString;
    }
}
