package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadKSRTCDataFromExcel {

	public static void main(String[] args) throws IOException {
		// Specify your Excel file path
		String filePath = "KSRTC_Bus_Data.xlsx";

		// Load Excel file
		FileInputStream fis = new FileInputStream(new File("./testData/testScriptData.xlsx/"));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0); // Read the first sheet

		System.out.println("KSRTC Bus Data from Excel:\n");

		// Iterate through rows (skip header at index 0)
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);

			String trip = row.getCell(0).getStringCellValue();
			String busNumber = row.getCell(1).getStringCellValue();
			String operator = row.getCell(2).getStringCellValue();
			String departure = row.getCell(3).getStringCellValue();
			String arrival = row.getCell(4).getStringCellValue();
			String duration = row.getCell(5).getStringCellValue();
			double price = row.getCell(6).getNumericCellValue();
			int seats = (int) row.getCell(7).getNumericCellValue();

			System.out.println("Trip: " + trip + ", Bus No: " + busNumber + ", Operator: " + operator + ", Departure: "
					+ departure + ", Arrival: " + arrival + ", Duration: " + duration + ", Price: ₹" + price
					+ ", Seats: " + seats);
		}

		// Close workbook and file input
		workbook.close();
		fis.close();
	}
}
