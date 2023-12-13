package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelFileUtility
{
	 public String readdatafromexcelfile(String str,int i, int j) throws EncryptedDocumentException, IOException
	 {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
	
  	Workbook wb=WorkbookFactory.create(fis);
	
  	Sheet sh = wb.getSheet(str);

	Row rw = sh.getRow(i);
	
	Cell cl = rw.getCell(j);
	
	String excval = cl.getStringCellValue();
	return excval;	
	 }
	 /**
	  * this method will read data from excel and helps to provide data to data provider
	  * @param str
	  * @param i
	  * @param j
	  * @return
	  * @throws EncryptedDocumentException
	  * @throws IOException
	  */
	 
	 public Object[][] readMultipleDataFromExcel(String str) throws EncryptedDocumentException, IOException
	 { 
		 FileInputStream fis=new FileInputStream("C:\\Users\\sande\\Desktop\\Book1.xlsx");

		  	Workbook wb=WorkbookFactory.create(fis);
		  	Sheet sh = wb.getSheet(str);
		  	int lastRow=sh.getLastRowNum();
		  	int lastCell=sh.getRow(0).getLastCellNum();
		  	
		  	Object[][] data=new Object[lastRow][lastCell];
		  	
		  	for(int i1=0;i1<lastRow;i1++)
		  	{
		  		for(int j1=0;j1<lastCell;j1++)
		  		{
		  			data[i1][j1]=sh.getRow(i1+1).getCell(j1).toString();
		  		}
		  	}
	
		  	return data;

	}}