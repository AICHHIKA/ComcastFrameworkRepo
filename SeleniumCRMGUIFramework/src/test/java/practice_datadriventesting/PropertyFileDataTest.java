package practice_datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileDataTest {

	public static void main(String[] args) throws Throwable {
		
		// Step 1: get the java representation object of the physical file
//		String str ="./src/test/resources/commondata.properties‪";
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		// Step 2: using properties class, load all the keys
		Properties pObj=new Properties();
		pObj.load(fis);
		
		// Step 3: get the value based on key
		System.out.println(pObj.getProperty("browser"));
		System.out.println(pObj.getProperty("url"));
		
	}
}
