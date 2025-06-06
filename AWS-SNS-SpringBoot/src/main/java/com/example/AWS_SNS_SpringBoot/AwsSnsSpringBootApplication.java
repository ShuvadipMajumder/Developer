package com.example.AWS_SNS_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

@SpringBootApplication
@RestController
public class AwsSnsSpringBootApplication {

	@Autowired
    private AmazonSNSClient snsClient;

	@Value("${aws.sns.topic.arn}")
	private  String topicArn;

	@GetMapping("/addSubscription/{email}")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(topicArn, "email", email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : " + email;
	}

	 @GetMapping("/sendNotification")
	public String publishMessageToTopic(){
		 PublishRequest publishRequest=new PublishRequest(topicArn,buildEmailBody(),"Notification: Network connectivity issue");
		 PublishResult publishResult =  snsClient.publish(publishRequest);
		 System.out.println("MessageId - "+publishResult.getMessageId());
		 return "Notification send successfully !!";
	}



	private String buildEmailBody(){
		return "Dear Employee ,\n" +
				"\n" +
				"\n" +
				"Connection down Bangalore."+"\n"+
				"All the servers in Bangalore Data center are not accessible. We are working on it ! \n" +
				"Notification will be sent out as soon as the issue is resolved. For any questions regarding this message please feel free to contact IT Service Support team";
	}
	public static void main(String[] args) {
		SpringApplication.run(AwsSnsSpringBootApplication.class, args);
	}

}
