package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// step 1 : get the Excel path location & java Object of the physical ExcelFile
		FileInputStream fis=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
		
		// step 2 : open WorkBook in read Mode
		Workbook wb=WorkbookFactory.create(fis);
		
		// step 3 : get the control of the "org" sheet
		Sheet sh=wb.getSheet("org");
		
		// step 4 : get the control of the "1st" Row
		Row row=sh.getRow(1);
		
		// step 5 : get the control of the "2nd" cell & read the String data
//		double data=row.getCell(3).getNumericCellValue();
		
//		String data=cel.getStringCellValue();
		String data =row.getCell(3).toString();
		System.out.println(data);
		// step 6 : close the WorkBook
		wb.close();
	}
}
