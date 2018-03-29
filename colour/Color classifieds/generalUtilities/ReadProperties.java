package generalUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	public String filePath;
	public ReadProperties(String filePath)
	{
		System.out.println("Path given by the user :" + filePath);
		this.filePath = filePath;
	}
	static FileInputStream myFile;
	static Properties myProp;
	
	public static String readValue(String key)
	{
		try {
			myFile = new FileInputStream("E:\\Lavanya\\colour\\TestData\\colorClassified.Properties");
			myProp = new Properties();
			myProp.load(myFile);
		} catch ( Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return myProp.getProperty(key);
	}
	
	public  String readData(String key)
	{
		try {
			myFile = new FileInputStream(filePath);
			myProp = new Properties();
			myProp.load(myFile);
		} catch ( Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return myProp.getProperty(key);
	}
}



