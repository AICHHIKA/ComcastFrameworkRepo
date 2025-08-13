package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	// step 4: Enter all the details & create new Organizations
	// To Capture the Current System Date no need to pass any Argument
	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	// To Capture the Required Date Date 30 Days After
	public String getRequiredDateYYYYDDMM(int days) {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//	String startDate =sim.format(dateObj);
		Calendar cal = sim.getCalendar();
//	cal.add(Calendar.DAY_OF_MONTH, -30);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String reqDate = sim.format(cal.getTime());
		return reqDate;

	}
}
