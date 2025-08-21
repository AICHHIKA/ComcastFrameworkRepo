package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleTestDataFromExcelTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet1");
		for(int i=1; i<20; i++)
		{
			Row row=sh.getRow(i);
			String clmn1Data =row.getCell(0).toString();
			String clmn2Data=row.getCell(1).toString();
			System.out.println(clmn1Data + "\t" + clmn2Data);
		}
		wb.close();
		}
		
	}
