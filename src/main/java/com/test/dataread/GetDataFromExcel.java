package com.test.dataread;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.test.browsersetup.Browser;

public class GetDataFromExcel extends Browser {


	
	public static String getData(String sheetName , int row ,int col) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		CellType type =wb.getSheet(sheetName).getRow(row).getCell(col).getCellType();
		String value = "";

		if(type==CellType.STRING)
		{
			value = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();   
		}
		else if(type==CellType.NUMERIC)
		{
			int numValue = (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
			value = ""+numValue;
		}
		else if(type==CellType.BOOLEAN)
		{
			boolean boolValue =  wb.getSheet(sheetName).getRow(row).getCell(col).getBooleanCellValue();
			value = ""+boolValue;
		}
		return value;


	}

}
