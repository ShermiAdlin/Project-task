package com.te.pdfgeneration.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.te.pdfgeneration.entity.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class UserPDFExporter {
	
//	private List<User> users;
//	
//	private void writeTableHeader() {
//		
//	}
//	
//	private void writeTableData() {
//		
//	}
//	
//	public void export(HttpServletResponse response) {
//		Document document= new Document(PageSize.A4);
//		try {
//			PdfWriter.getInstance(document, response.getOutputStream());
//		} catch (DocumentException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		document.open();
//		document.add(new Paragraph("List of all users"));
//		document.close();
//	}
public static ByteArrayInputStream customerPDFReport(List<User> user) {
		
		Document document = new Document();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			
			document.open();

			// Add Text to PDF file ->
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 14);
			
			Paragraph para = new Paragraph("User", font);
			
			para.setAlignment(Element.ALIGN_CENTER);
			
			document.add(para);
			
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(3);
			
			// Add PDF Table Header ->
			
			Stream.of("Id", "Name", "Location").forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(2);
				header.setPhrase(new Phrase(headerTitle, headFont));
				table.addCell(header);
			});

			for (User users : user) {
				PdfPCell id = new PdfPCell(new Phrase(users.getId().toString()));
				id.setPaddingLeft(4);
				id.setVerticalAlignment(Element.ALIGN_MIDDLE);
				id.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(id);

				PdfPCell name = new PdfPCell(new Phrase(users.getUserName()));
				name.setPaddingLeft(4);
				name.setVerticalAlignment(Element.ALIGN_MIDDLE);
				name.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(name);

				PdfPCell location = new PdfPCell(new Phrase(String.valueOf(users.getLocation())));
				location.setVerticalAlignment(Element.ALIGN_MIDDLE);
				location.setHorizontalAlignment(Element.ALIGN_RIGHT);
				location.setPaddingRight(4);
				table.addCell(location);
				
			}
			document.add(table);

			document.close();
			
			
		} catch (DocumentException e) {
			
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}
