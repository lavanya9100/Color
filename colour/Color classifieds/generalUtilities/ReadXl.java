package generalUtilities;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ReadXl {

	FileInputStream myFile;
	Workbook myBook ;
	Sheet mySheet;
	String filePath;
	public ReadXl(String filePath)
	{
		this.filePath = filePath;
	}
	public Sheet getMySheet(String sheetName)
	{
		try {
			myFile = new FileInputStream(filePath);
			//myFile = new FileInputStream("E:\\Lavanya\\example2\\TestData3.Properties\\Gmail4.xls");
			myBook = Workbook.getWorkbook(myFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myBook.getSheet(sheetName);
	}
	public int getRowCount(String sheetName)
	{
		mySheet = getMySheet(sheetName);
		return mySheet.getRows();
		
	}
	
	public int getColumnCount(String sheetName) 
	{
		mySheet = getMySheet(sheetName);
		return mySheet.getColumns();
		
	}
	
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		mySheet = getMySheet(sheetName);
		return mySheet.getCell(colNum, rowNum).getContents();
	}
	
}


