package com.example.springai_ollama_gemma3.service;

import java.io.IOException;
import java.util.List;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.model.Media;
//import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class AIService {

	@Autowired
	OllamaChatModel ollamaChatModel;
	
	// generate response in JSON format
	public String getChatResponse(String cat, String yr) {
		
		String template="""
					Please provide me best book for the given {category} and the {year}.
	                 Please do provide a summary of the book as well, the information should be\s
	                 limited and not much in depth. The response should be in the JSON format
	                 containing this information:
	                 category, book, year, review, author, summary
				""";
		
		PromptTemplate promptTemplate=new PromptTemplate(template);
		promptTemplate.add("category", cat);
		promptTemplate.add("year", yr);
		
		Prompt prompt=promptTemplate.create();
		return ollamaChatModel.call(prompt).getResult().getOutput().getText();
		
	}
	
	// summarize text in the structured format
	public String getSummary(String text) {
		String template ="""
				You will be given an {article}. 
                 You need to summarize it and provide the
                 output in the JSON format with these keys : 
                 topic, highlights.
				""";
		
		PromptTemplate promptTemplate= new PromptTemplate(template);
		promptTemplate.add("article", text);
		
		Prompt prompt=promptTemplate.create();
		return ollamaChatModel.call(prompt).getResult().getOutput().getText();
	}
	
	// multimodal - read images
	public String getMultimodalResponse () {
		
		try {
			//byte[] imageData= new ClassPathResource("/landscape.jpg").getContentAsByteArray();
			//var userMessage= new UserMessage("Explain what do you see on this picture?", List.of(new Media(MimeTypeUtils.IMAGE_JPEG,imageData)));
			
			var imageResource = new ClassPathResource("/landscape.jpg");
			var userMessage = new UserMessage("Explain what do you see on this picture? express the mood of the nature in the picture.",
				    new Media(MimeTypeUtils.IMAGE_JPEG, imageResource));
			return ollamaChatModel.call(new Prompt(userMessage)).getResult().getOutput().getText();
			
		} catch (Exception e) {
			System.out.println("Exception in image read");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Could not read the image due to exception";
		}
		
	}
	
	

}
