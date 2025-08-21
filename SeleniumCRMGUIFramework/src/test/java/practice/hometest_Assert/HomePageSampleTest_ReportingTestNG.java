package practice.hometest_Assert;

import java.lang.reflect.Method;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageSampleTest_ReportingTestNG {

	@Test
	public void homePageTest(Method mtd) {

		Reporter.log(mtd.getName() + "Test Start");
		// Reporter coming from TestNG
		//Want to see Logs in Eclipse , for that use "true"
		Reporter.log("step-1", true);
		Reporter.log("step-2", true);
		Reporter.log("step-3", true);
		Reporter.log("step-4", true);
		Reporter.log(mtd.getName() + "Test End");
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log(mtd.getName() + "Test Start");
		Reporter.log("step-1", true);
		Reporter.log("step-2", true);
		Reporter.log("step-3", true);
		Reporter.log("step-4", true);
		Reporter.log(mtd.getName() + "Test END");
	}
}
