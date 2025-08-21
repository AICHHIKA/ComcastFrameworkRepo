package practice_datadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class NC_ReadDataBasedOnCondition {

	public static void main(String[] args) throws Throwable {
		
		//Read Common Data from Properties file
				String dataColumn1="";
				String dataColumn2="";
				String dataColumn3="";

				FileInputStream fis=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet("org");
			
				// Read Complete Row Count
				int rowcount = sh.getLastRowNum();
				//After read this Row Count use For Loop, Go each 7 every Row & capture only 1st Column
				//If the value repeated then: we have to put it in for loop
				for(int i=0; i<=rowcount; i++)
				{
				String data="";
				// Read 1st column data
				// If we have blank space, to handle this go for: try catch block
				try {
				data =sh.getRow(i).getCell(0).toString();
					{
						dataColumn1 =sh.getRow(i).getCell(1).toString();
						dataColumn2 =sh.getRow(i).getCell(2).toString();
						dataColumn3 =sh.getRow(i).getCell(3).toString();
					}
				}
				catch(Exception e){}			
				}
					
			System.out.println(dataColumn1);
			System.out.println(dataColumn2);
			System.out.println(dataColumn3);
			}
			
		}
		
