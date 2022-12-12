package com.te.pdfgeneration.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.pdfgeneration.entity.User;
import com.te.pdfgeneration.service.UserPDFExporter;
import com.te.pdfgeneration.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> register(@Valid @RequestBody User user){
		User user2 = service.addUser(user);
		
		return new ResponseEntity<User>(user2,HttpStatus.OK);
	}
//	//set headers for file download
//	@GetMapping("/user/export")
//	public void exportToPDF(HttpServletResponse response) {
//		response.setContentType("application/pdf");
//		String headerKey="ContentDisposition";
//		String headerValue="attachment; filename=user.pdf";
//		response.setHeader(headerKey, headerValue);
//	//getting datas from database
//		List<User> users=service.findALL();
//	
//		UserPDFExporter exporter= new UserPDFExporter();
//		exporter.export(response);
//	}
	
	 @GetMapping("/users")
     ResponseEntity<InputStreamResource> customerReport() throws IOException {
        List<User> all = service.findALL();

        ByteArrayInputStream bis = UserPDFExporter.customerPDFReport(all);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=users.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
