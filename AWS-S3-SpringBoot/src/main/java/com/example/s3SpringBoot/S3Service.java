package com.example.s3SpringBoot;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

@Service
public class S3Service {

	private final S3Client s3Client;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	public S3Service(S3Client s3Client) {
		this.s3Client = s3Client;
	}

	public String uploadFile(String key, String filePath) {
		PutObjectRequest request = PutObjectRequest.builder().bucket(bucketName).key(key).build();

		s3Client.putObject(request, RequestBody.fromFile(Paths.get(filePath)));
		return "File uploaded successfully: " + key;
	}

	public List<String> listFiles() {
		ListObjectsV2Request listReq = ListObjectsV2Request.builder().bucket(bucketName).build();

		ListObjectsV2Response res = s3Client.listObjectsV2(listReq);
		return res.contents().stream().map(S3Object::key).collect(Collectors.toList());
	}

	public void downloadFile(String key, String destinationPath) {
		GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(key).build();

		s3Client.getObject(request, Paths.get(destinationPath));
	}

	public void deleteFile(String key) {
		DeleteObjectRequest request = DeleteObjectRequest.builder().bucket(bucketName).key(key).build();

		s3Client.deleteObject(request);
	}
}
