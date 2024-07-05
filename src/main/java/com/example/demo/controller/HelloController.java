package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("i am in demo project");
		return "Hello demo1";
	}
	
	@Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public ResponseEntity<String> callApi(@RequestParam String pathUrl) {
        // Call the second API
        ResponseEntity<String> response = restTemplate.getForEntity(pathUrl, String.class);
        System.out.println("Response : " + response);
        // Return the response from the second API as this API's response
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

}
