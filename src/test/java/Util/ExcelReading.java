package Util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
//	public static void main(String[] args) throws IOException {
//		ExcelReading read = new ExcelReading("C:\\Users\\da.george\\eclipse-workspace\\Selenium\\excel\\data.xlsx","Sheet1");
//		read.rowCount();
//		read.columnCount();
//		read.getCellValue(2,1);
//	
//		
//	}
	public ExcelReading(String filename, String sheetname) throws IOException
	{
	 workbook = new  XSSFWorkbook(filename);
	 sheet= workbook.getSheet(sheetname);	
	}
	public  int getrowCount() 
	{
		
	int rowcount =sheet.getPhysicalNumberOfRows();
	
	return rowcount;
			
	}
	public  int getcolumnCount()
	{
		int columncount =sheet.getRow(0).getPhysicalNumberOfCells();
		
		return columncount;
	}
	public Object getCellValue(int rowNumber,int columnNumber)
	{
		Object data =sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	//	System.out.println("Data value is "+data);
		return data;
	}
	

}
