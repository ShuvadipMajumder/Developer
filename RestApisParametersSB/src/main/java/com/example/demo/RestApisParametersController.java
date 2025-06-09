package com.example.demo;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class RestApisParametersController {
	
	 // GET with @PathVariable and @RequestHeader
	@GetMapping ("/users/{id}")
	public ResponseEntity<String> getUserById(
			@PathVariable("id") int id,
			@RequestHeader (value="client-name", required=false) String clientName
			){
		return ResponseEntity.ok("User ID: " + id + ", Requested by: " + clientName);		
	}
	
	
	// GET with @RequestParam
	@GetMapping ("/search")
	public ResponseEntity<String> searchProduct(@RequestParam String name){
		return ResponseEntity.ok("Searching for product : " + name);
	}
	
	// POST with @RequestBody
	@PostMapping ("/users")
	public ResponseEntity<String> createUser(@RequestBody Map<String, Object> userData ){
		return ResponseEntity.ok("User created with data: " +userData);
	}
	
	// PUT with @RequestBody and @PathVariable
	@PutMapping ("/users/{id}")
	public ResponseEntity<String> updateUser(
			@PathVariable("id") int id,
			@RequestBody Map<String, Object> updatedUser
			){
		return ResponseEntity.ok("User ID " + id + " updated with data: " + updatedUser);
	}
	
	// DELETE with @PathVariable
	@DeleteMapping ("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
		return ResponseEntity.ok("User ID " + id + " deleted.");
	}
	
	// POST with @RequestPart (file upload)
	@PostMapping ("/upload")
	public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file){
		return ResponseEntity.ok("Uploaded file : "+file.getOriginalFilename());
	}
	
	

}
