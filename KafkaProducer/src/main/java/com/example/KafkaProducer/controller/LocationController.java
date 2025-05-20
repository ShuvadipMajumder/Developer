package com.example.KafkaProducer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.KafkaProducer.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@PutMapping
	public ResponseEntity<Map<String, String>> updateLocation() {
		System.out.println("Inside LocationController updateLocation");
		int range =20;
		while (range >0) {
			locationService.updateLocation(Math.random() + " , " + Math.random());
            range --;
		}
		return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
		
	}

}
