package testPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page_objects {

	WebDriver driver;
	
	public Login_page_objects(WebDriver d) {
		driver=d;
	}
	
	By agencyid=By.xpath("//input[@placeholder='ENTER AGENCY ID']");
	By Password=By.xpath("//input[@placeholder='ENTER PASSWORD']");
	By submit=By.xpath("//div[@role='button']");
	
	public void enteragency(String name) {
		driver.findElement(agencyid).sendKeys(name);
	}
	public void enterpass(String name) {
		driver.findElement(Password).sendKeys(name);
	}
	public void clickonlogin() {
		driver.findElement(submit).click();
	}
}
