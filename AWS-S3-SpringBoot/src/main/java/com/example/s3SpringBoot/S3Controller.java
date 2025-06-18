package com.example.s3SpringBoot;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

	private final S3Service s3Service;

	public S3Controller(S3Service s3Service) {
		this.s3Service = s3Service;
	}

	// curl -X POST
	// "http://localhost:8080/api/s3/upload?key=SampleUpload.txt&filePath=C:/Workspace/Developer/AWS-S3-SpringBoot/uploadDir/SampleUpload.txt"
	@PostMapping("/upload")
	public String upload(@RequestParam String key, @RequestParam String filePath) {
		return s3Service.uploadFile(key, filePath);
	}

	// curl http://localhost:8080/api/s3/list
	@GetMapping("/list")
	public List<String> listFiles() {
		return s3Service.listFiles();
	}

	// curl GET
	// "http://localhost:8080/api/s3/download?key=SampleUpload.txt&destinationPath=C:/Workspace/Developer/AWS-S3-SpringBoot/downDir/SampleUpload.txt"
	@GetMapping("/download")
	public String download(@RequestParam String key, @RequestParam String destinationPath) {
		s3Service.downloadFile(key, destinationPath);
		return "Downloaded to: " + destinationPath;
	}

	// curl -X DELETE "http://localhost:8080/api/s3/delete?key=SampleUpload.txt
	@DeleteMapping("/delete")
	public String delete(@RequestParam String key) {
		s3Service.deleteFile(key);
		return "Deleted: " + key;
	}
}
