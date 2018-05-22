package com.zaffer.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class RestTest {
  private static final Logger LOG = LoggerFactory.getLogger(RestTest.class);

  private String server = "http://192.168.151.138:35357";
  //private String server = "http://127.0.0.1:8888";
  private RestTemplate rest;
  private HttpHeaders headers;
  private HttpStatus status;

  public RestTest() {
    this.rest = new RestTemplate();
    this.headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
  }

  public String get(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity("", headers);
    ResponseEntity<String> responseEntity = rest
        .exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public String post(String uri, String json) {
    HttpEntity<String> requestEntity = new HttpEntity(json, headers);
    ResponseEntity<String> responseEntity = rest
        .exchange(server + uri, HttpMethod.POST, requestEntity, String.class);
    for (Map.Entry<String,List<String>> entry : responseEntity.getHeaders()
        .entrySet()) {
      System.out.print(entry.getKey() + " : ");
      System.out.println(entry.getValue().get(0));
    }
    this.setStatus(responseEntity.getStatusCode());
    return responseEntity.getBody();
  }

  public void put(String uri, String json) {
    HttpEntity<String> requestEntity = new HttpEntity(json, headers);
    //ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.PUT, requestEntity, null);
    //this.setStatus(responseEntity.getStatusCode());
  }

  public void delete(String uri) {
    HttpEntity<String> requestEntity = new HttpEntity("", headers);
    //ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.DELETE, requestEntity, null);
    //this.setStatus(responseEntity.getStatusCode());
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public static void main(String[] args) {
    String url = "/v3/auth/tokens";

    RestTest test = new RestTest();
    //String str = test.get("/v3/auth/tokens");
    String postResp = test
        .post(url, JsonTools.createAuthString(JsonTools.createAuthObject()));

    System.out.println(postResp);
  }
}
