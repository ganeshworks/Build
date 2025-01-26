package testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;



import test_Utilities.Read_Config;

public class BaseClass {
	
	Read_Config read=new Read_Config();

	public static WebDriver driver;
	
	public static Logger logg;
	
	public String geturl =read.geturl();
	
	/*
	 * @BeforeTest public void setup() {
	 * System.setProperty("webdriver.chrome.driver", read.getchromepath());
	 * driver=new ChromeDriver();
	 * 
	 * logg = Logger.getLogger("Mylpgbooks");
	 * PropertyConfigurator.configure("log4j.properties"); }
	 */
	
}
