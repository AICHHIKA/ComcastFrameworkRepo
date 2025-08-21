package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {
	
	//Condition: Go to the sheet, Check whether TestCase Id(tc_02) is available/not,
	// if it is available read this complete row data (ex: instagram social)
	//Expected Condition is: if Test Case(tc_02) is available, read that complete row data
	
	//Strategies: 1st: I will read this complete 1st column data, 
	//		   2nd:after read this i have to compare expected with actual Test Case Id(tc_02),
	//         3rd:if it is available i will break my condition/ loop & read the complete row data
	
	//Program: 1st: I will read complete row count(ex:8), 
	//		   2nd: After read this Row Count i will use For Loop, 
    //              using this loop i will read 1st column data & compare with expected result data
	//         3rd: If the ED is available somewhere , i will capature the Row Index, I will read the complete Row Data,
	//              I will Break the Loop
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Declare variable Globally
//		String data="";
		String expectedTestId= "tc_02";
		//If the Test Case Id(tc_100) is not available/deleted, 
//		String expectedTestId= "tc_100";
		// we have to declare this dataColumn1 2 3 variable
		String dataColumn1="";
		String dataColumn2="";
		String dataColumn3="";
		//If the Test Case Id(tc_100) is not available/deleted, that case we use Flag Variable, the default value
		//of this variable is false (Declare: boolean flag=false;) 
		boolean flag=false;
		
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
				
		// Apply Condition here: If the data is equals to() expected data,
				if(data.equals(expectedTestId)) 
		// come inside this conditional block & Go to same Row Read 1st column data & 
		// Read 2nd column data, & Display 3rd Column Data 
			// we have to declare this dataColumn1 2 3 variable
				{
					dataColumn1 =sh.getRow(i).getCell(1).toString();
					dataColumn2 =sh.getRow(i).getCell(2).toString();
					dataColumn3 =sh.getRow(i).getCell(3).toString();
				}
			}
			catch(Exception e){}			
			
			//for facing error, we have to declare this variable Globally
			// We don't display this sopln variable for that comment
//			System.out.println(data);
		}
		
		//If the data is available Outside the for loop we have to mention if(flag==true)
		
		if(flag==true) {
		System.out.println(dataColumn1);
		System.out.println(dataColumn2);
		System.out.println(dataColumn3);
		}
		else {
			System.out.println(expectedTestId + " data is not available");
		}
	}
}


