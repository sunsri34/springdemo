package com.westpac.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.westpac.entity.Application;

public class RestClientUtil {
    public void getApplicationByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/westpac/application/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Application> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Application.class, 1);
        Application article = responseEntity.getBody();
        System.out.println("Id:"+article.getApplicationId()+", Title:"+article.getTitle()
                 +", Category:"+article.getCategory());      
    }
	public void getAllApplicationsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/westpac/applications";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Application[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Application[].class);
        Application[] articles = responseEntity.getBody();
        for(Application article : articles) {
              System.out.println("Id:"+article.getApplicationId()+", Title:"+article.getTitle()
                      +", Category: "+article.getCategory());
        }
    }
    public void addApplicationDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/westpac/application";
	    Application objArticle = new Application();
	    objArticle.setTitle("Spring REST Security using Hibernate");
	    objArticle.setCategory("Spring");
        HttpEntity<Application> requestEntity = new HttpEntity<Application>(objArticle, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateApplicationDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/westpac/application";
	    Application objArticle = new Application();
	    objArticle.setApplicationId(1);
	    objArticle.setTitle("Update:Java Concurrency");
	    objArticle.setCategory("Java");
        HttpEntity<Application> requestEntity = new HttpEntity<Application>(objArticle, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteApplicationDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/westpac/application/{id}";
        HttpEntity<Application> requestEntity = new HttpEntity<Application>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getApplicationByIdDemo();
    	util.getAllApplicationsDemo();
    	//util.addApplicationDemo();
    	//.updateApplicationDemo();
    	//util.deleteApplicationDemo();
    }    
}
