package adv_Selenium_Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Task_2_MultipleData_Rows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String expectedTestId= "sheet3";
	
		String dataColumn1="";
		String dataColumn2="";
		
		FileInputStream fis=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet3");
	
		int rowcount = sh.getLastRowNum();
	
		for(int i=0; i<=rowcount; i++)
		{
			String data="";
	
			try {
				data =sh.getRow(i).getCell(0).toString();
	
				if(data.equals(expectedTestId)) 
	
				{
					dataColumn1 =sh.getRow(i).getCell(1).toString();
					dataColumn2 =sh.getRow(i).getCell(2).toString();
					}
			}
			catch(Exception e){}			
		System.out.println(data);
		}
		System.out.println(dataColumn1);
		System.out.println(dataColumn2);
	
		}
	
	}

