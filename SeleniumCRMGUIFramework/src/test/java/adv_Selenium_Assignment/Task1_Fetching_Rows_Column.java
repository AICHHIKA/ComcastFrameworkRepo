package adv_Selenium_Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Task1_Fetching_Rows_Column {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet2");
	
		for(int i=0; i<7; i++)
		{
			Row row=sh.getRow(i);
			String Data1 =row.getCell(0).toString();
			String Data2=row.getCell(1).toString();
			System.out.println(Data1 + "\t:  " + Data2);
		}
		wb.close();
	}
}


