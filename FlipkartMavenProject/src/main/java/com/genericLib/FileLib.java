package com.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	
	public String getPropertyKeyValue(String path,String key)
	{
	
		FileInputStream ip=null;
		Properties prop=null;
		try
		{
			ip=new FileInputStream(path);
			prop=new Properties();
			prop.load(ip);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	 
		
		
	}
	
	
	public String getExcelData(String path,String sheetName,int rowNum,int cellNum)
	{
		FileInputStream ip;
		Workbook wb = null;
		try
		{
			ip=new FileInputStream(path);
			wb=WorkbookFactory.create(ip);
			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		
		
}

}