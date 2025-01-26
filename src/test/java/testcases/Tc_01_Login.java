package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import testPageObjects.Login_page_objects;
import test_Utilities.ExcelDataSupplier;

public class Tc_01_Login extends BaseClass {

	 @Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class, priority = 1)
	    public void login(String AgencyId, String Password) throws Exception {
		 Thread.sleep(2000);
	        // Set the ChromeDriver path
	        System.setProperty("webdriver.chrome.driver", read.getchromepath()); // Update the path to your chromedriver

	        // Launch a new Chrome browser instance
	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.get(geturl); // Replace 'geturl' with your actual URL variable
	            Login_page_objects Lp = new Login_page_objects(driver);

	            // Perform login steps
	            Lp.enteragency(AgencyId);
	            Lp.enterpass(Password);
	            Lp.clickonlogin();

	            // Add any additional validation logic if needed
	        }catch(Exception e) {
	        	
	        }
	    }
}
