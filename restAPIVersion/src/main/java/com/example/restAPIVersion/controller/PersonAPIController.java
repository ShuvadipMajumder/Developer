package com.example.restAPIVersion.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


record PersonV1(String name, int age) {}
record PersonV2(String name, int age, String address) {}

@RestController
@RequestMapping("/persons")
public class PersonAPIController {
	
	PersonV1 populatePersonV1(){
		return new PersonV1("Sundar",25);
	}
	
	PersonV2 populatePersonV2(){
		return new PersonV2("Sundar",25,"USA");
	}
	
	//http://localhost:8080/persons/v1/person
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1Uri() {
		return populatePersonV1();
	}
	//http://localhost:8080/persons/v2/person
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2Uri() {
		return populatePersonV2();
	}
	
	//http://localhost:8080/persons/person/params?version=1
	@GetMapping(value="/person/params", params="version=1")
	public PersonV1 getPersonV1Params() {
		return populatePersonV1();
	}
	//http://localhost:8080/persons/person/params?version=2
	@GetMapping(value="/person/params", params="version=2")
	public PersonV2 getPersonV2Params() {
		return populatePersonV2();
	}
	
	//http://localhost:8080/persons/person/headers
	//Headers key="api-version-1" value="api-version-1"
	@GetMapping(value="/person/headers", headers="api-version-1")
	public PersonV1 getPersonV1Headers() {
		return populatePersonV1();
	}
	//http://localhost:8080/persons/person/headers
	//Headers key="api-version-2" value="api-version-2"
	@GetMapping(value="/person/headers", headers="api-version-2")
	public PersonV2 getPersonV2Headers() {
		return populatePersonV2();
	}
	
	//http://localhost:8080/persons/person/produces
	//Headers key="Accept" value="application/json"
	@GetMapping(value="/person/produces", produces={MediaType.APPLICATION_JSON_VALUE})
	public PersonV1 getPersonV1Produces() {
		return populatePersonV1();
	}
	//http://localhost:8080/persons/person/produces
	//Headers key="Accept" value="application/xml"
	@GetMapping(value="/person/produces", produces={MediaType.APPLICATION_XML_VALUE})
	public PersonV2 getPersonV2Produces() {
		return populatePersonV2();
	}

}
