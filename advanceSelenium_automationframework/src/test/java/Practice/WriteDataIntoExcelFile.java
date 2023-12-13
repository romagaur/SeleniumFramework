package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteDataIntoExcelFile {
	
	public static void main(String[] args) throws  NullPointerException,IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("CONTACTS");
		Row rw = sh.createRow(8);
		Cell cl = rw.createCell(10);
		cl.setCellValue("Garima");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Book1.xlsx");
		wb.write(fos);
	}

}
