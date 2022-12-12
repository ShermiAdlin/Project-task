package com.te.email.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,String subject, String body) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("shermivijay@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("mail sent successfully...");
	}
	
	public void sendMailAttachment(String toEmail,String body,String subject, String attachment) throws MessagingException {
MimeMessage mimeMessage=mailSender.createMimeMessage();
MimeMessageHelper mimeMessageHelper
=new MimeMessageHelper(mimeMessage,true);
mimeMessageHelper.setFrom("shermiviajy@gmail.com");
mimeMessageHelper.setTo(toEmail);
mimeMessageHelper.setText(body);
mimeMessageHelper.setSubject(subject); 
FileSystemResource fileSystemResource
=new FileSystemResource(new File(attachment));
mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
mailSender.send(mimeMessage);
System.out.println("mail with attachment sent succesfully");
	}

}