package test_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_Config {

	Properties pro;
	
	public Read_Config() {
		File src=new File("./config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			System.out.println("exception was :"+e.getMessage());
		}
	}
	public String geturl() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getchromepath() {
		String chrome=pro.getProperty("chrome");
		return chrome;
	}
}
