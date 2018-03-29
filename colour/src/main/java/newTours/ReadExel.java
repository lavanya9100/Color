package newTours;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExel {
	@Test
	public void readXlData() throws BiffException, IOException
	{
		FileInputStream myFile = new FileInputStream("E:\\Lavanya\\colour\\Excel10.xls");
		Workbook myBook = Workbook.getWorkbook(myFile);
		Sheet mySheet = myBook.getSheet("Sheet1");
		int colCnt = mySheet.getColumns();
		int rowCnt = mySheet.getRows();
		String url = mySheet.getCell(0, 9).getContents();
		String userName = mySheet.getCell(1, 9).getContents();
		String passWord = mySheet.getCell(2, 9).getContents();
		for(int i=0;i<rowCnt;i++)
		{
			for(int j=0;j<colCnt;j++)
			{
				System.out.println("My Value from row :" + i + "" + j + " is : " + mySheet.getCell(j, i).getContents() );
			}
			
		}
		System.out.println("Column Count:" + colCnt);
		System.out.println("row Count:" + rowCnt);
		System.out.println("url :" + url);
		System.out.println("username :" + userName);
		System.out.println("password :" + passWord);
	}
}


	
	
	
	
	


