//package practice_datadriventesting;
//
//import java.io.FileReader;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class ReadDataFromJsonTest {
//
//	public static void main(String[] args) throws Throwable, Throwable, Throwable {
//
//		//Step 1: parse Json Physical File in to Java Object using JsonParse Class
//		JSONParser parser=new JSONParser();
//		Object obj=parser.parse(new FileReader("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\appCommonData.json"));
//		
//		//Step 2: Convert Java Object in to Json Object using DownCasting
//		JSONObject map=(JSONObject) obj;
//		
//		//Step 3: get the Value From Json File using Key 
//		System.out.println(map.get("url"));
//		System.out.println(map.get("username"));
//		System.out.println(map.get("password"));
//		System.out.println(map.get("timeout"));
//		
//	}
//
//}
