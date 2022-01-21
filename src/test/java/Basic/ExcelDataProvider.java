package Basic;

import java.io.IOException;

import Util.ExcelReading;

public class ExcelDataProvider {
	
//	public static void main(String[] args) throws IOException {
//		testdata("C:\\Users\\da.george\\eclipse-workspace\\Selenium\\excel\\data.xlsx","Sheet1");
//		
//	}
	public static Object[][] testdata(String excelpath, String sheetname) throws IOException
	{
		ExcelReading read = new ExcelReading(excelpath, sheetname);
		int rowcount= read.getrowCount();
		int columncount =read.getcolumnCount();
		Object data[][] = new Object[rowcount-1][columncount];
		System.out.println("No. of row :"+rowcount);
		System.out.println("column no. is "+columncount);
		for (int i=1; i<rowcount; i++)
		{
			for (int j=0;j<columncount;j++)
			{
				 data[i-1][j] =read.getCellValue(i, j);
				System.out.println("Data is--- "+data[i-1][j].toString());
			}
		}
		return data;
	}
	

}
