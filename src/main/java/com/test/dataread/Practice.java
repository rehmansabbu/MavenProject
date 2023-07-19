package com.test.dataread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Practice {
	
	public static String getData(String sn , int row, int col) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		CellType type =wb.getSheet(sn).getRow(row).getCell(col).getCellType();
		String value = "";
		
		if(type == CellType.STRING)
		{
			value = wb.getSheet(sn).getRow(row).getCell(col).getStringCellValue();
		}
		
		else if (type==CellType.NUMERIC)
		{
			int numValue =(int) wb.getSheet(sn).getRow(row).getCell(col).getNumericCellValue();
			 value = numValue + "";
		}
		
		else if(type==CellType.BOOLEAN)
		{
			
			boolean volValue = wb.getSheet(sn).getRow(row).getCell(col).getBooleanCellValue();
			
			value = volValue +"";
			
		}
		
		
		
		return value;
		
	}
	
	
	
	    
		
		
	}
	
	
	
		
		
				
	
	

	


