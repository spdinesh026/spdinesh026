package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.AppBase;
import Extent.ExtentListeners;

public class ApiRough extends AppBase {
	
	
	@Test(priority = 1)
	public void Login() {

		values("UserEmail_XPATH", "random021@berijam.com");
		ExtentListeners.test.log(Status.INFO, "Entering name");
		values("UserPassword_XPATH", "Test123$");
		click("SignIn_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("FirmUser"))));
		
	//((JavascriptExecutor) driver).executeScript("console.log('userData.sessionKey')");
	String key1 = (String) ((JavascriptExecutor) driver).executeScript("return userData.sessionKey;");
		System.out.println(key1);
	}
	
	
	

}
