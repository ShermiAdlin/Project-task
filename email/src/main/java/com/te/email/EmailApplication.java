package com.te.email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.te.email.service.EmailService;

@SpringBootApplication
public class EmailApplication {
@Autowired
	private EmailService service;
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		service.sendEmail("vedhaa20@gmail.com", "Subject","Hi vedha");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		service.sendMailAttachment("vedhaa20@gmail.com", "body","mail with attachment","C:\\Users\\ssyed\\Downloads\\Vedanayaki K_TYResume.docx");
	}

}
