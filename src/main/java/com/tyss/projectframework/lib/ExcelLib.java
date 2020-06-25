package com.tyss.projectframework.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	public static String getData(String sheet,int row,int cell,String filepath) 
	{
		String data="";
		
		try {
			FileInputStream fin = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fin);
	Cell c = wb.getSheet(sheet).getRow(row).getCell(cell);		
	data = c.getStringCellValue();
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return data;
		
	}
	

}
