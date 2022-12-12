package com.te.excel.helpers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.te.excel.entity.Product;
public class Helpers {
	//to check whether file is excel or not
		public static boolean checkExcelFormat(MultipartFile file) {
			
			String contentType = file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
		}

		
		
		//excel to list
		
		
		public static List<Product> convertExcelToList(InputStream is){
			 List<Product> list=new ArrayList<>();
		try {
			
			
		XSSFWorkbook workbook	=new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheet("sheet");
		Integer rowNumber=0;
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			if(rowNumber==0) {
				rowNumber++;
				continue;
			}
			Iterator<Cell> iterator2 = row.iterator();
		Integer cid=0;
		Product product= new Product();
		while (iterator2.hasNext()) {
			Cell cell = (Cell) iterator2.next();
			switch (cid) {
			case 0:
				
				//product.setProductId(Integer).cell.getNumericCellValue();
			product.setProductId((int)cell.getNumericCellValue());
			break;
			case 1:
				product.setProductName(cell.getStringCellValue());
				break;
				case 2:
					product.setPrroductDesc(cell.getStringCellValue());
					break;
					case 3:
						product.setProductPrice(cell.getNumericCellValue());
						break;
				

			default:
				break;
			}
			cid++;
		}
		list.add(product);
		}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return list;
		
		}


}
