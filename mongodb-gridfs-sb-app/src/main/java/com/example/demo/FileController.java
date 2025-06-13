package com.example.demo;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/files")
public class FileController {

	private final GridFsTemplate gridFsTemplate;
	private final GridFsOperations operations;

	public FileController(GridFsTemplate gridFsTemplate, GridFsOperations operations) {
		this.gridFsTemplate = gridFsTemplate;
		this.operations = operations;
	}

	// Upload file
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
		ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
		return ResponseEntity.ok("File uploaded with ID: " + id.toHexString());
	}

	// Download file
	@GetMapping("/download/{id}")
	public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
		GridFSFile file = gridFsTemplate.findOne(
				Query.query(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(new ObjectId(id))));

		if (file == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("File not found");
			return;
		}

		GridFsResource resource = operations.getResource(file);

		response.setContentType(file.getMetadata() != null && file.getMetadata().get("_contentType") != null
				? file.getMetadata().get("_contentType").toString()
				: MediaType.APPLICATION_OCTET_STREAM_VALUE);

		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFilename());

		StreamUtils.copy(resource.getInputStream(), response.getOutputStream());
	}

	// Delete file
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		gridFsTemplate.delete(
				Query.query(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(new ObjectId(id))));
		return ResponseEntity.ok("File deleted with ID: " + id);
	}
}
