package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.AppBase;
import Extent.ExtentListeners;

public class PaymentflowsPaypal extends AppBase {

	public void paypayDetailsLogin() {
		/*
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 * isElementPresent("PayPal_Agree_XPATH");
		 */
		isElementPresent("PayPal_Username_XPATH", "ramkumar@berijam.com");
		isElementPresent("Paypal_Next_XPATH");
		isElementPresent("PayPal_Pass_XPATH", "welcome123");
		isElementPresent("Paypal_Signin_XPATH");
		isElementPresent("Paypal_Accept_XPATH");

	}

	public void paypalDetails() {
		// click("Paypal_Accept_XPATH");Paypal_Terms_Xpath
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("Paypal_Terms_Xpath"))));
		WebElement paypalAgree = driver.findElement(By.xpath(variables.getProperty("Paypal_Policies_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paypalAgree);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Agree_XPATH"))));
		// click("PayPal_Agree_XPATH");
		isElementPresent("PayPal_Agree_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("Change_Plan_XPATH"))));

	}

	public void addLicences() {
		WebElement addlicense = driver.findElement(By.xpath(variables.getProperty("Licences_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addlicense);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licences_XPATH")))).click();
		// click("Licences_XPATH");
		click("Add_Licenses_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licenses_Number_XPATH"))))
				.sendKeys("3");
		click("AddLicenses_rough_XPATH");
		// isElementPresent("Licence_Count_XPATH", "3");
		/*
		 * WebElement LicenceNext =
		 * driver.findElement(By.xpath(variables.getProperty("Licences_Next_XPATH")));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", LicenceNext);
		 * 
		 * click("Licences_Next_XPATH");
		 */
	}

	public void reduceLicences() {
		click("Licences_XPATH");
		click("Reduces_Licences_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licenses_Number_XPATH"))))
				.sendKeys("3");
		click("AddLicenses_rough_XPATH");
		// values("Licenses_Number_XPATH", "3");
		click("Reduce_Button_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		// wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(variables.getProperty("Licenses_Reduced_Success_CSS")),"3
		// License(s) reduced."));

	}

	public void addAndReducePaypal() {
		addLicences();

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		paypalDetails();
		/*
		 * wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(variables.getProperty(
		 * "Card_Confirmation_Xpath")))); click("Card_Confirm_XPATH");
		 */
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		reduceLicences();
	}

	public void Login() {

		values("UserEmail_XPATH", "random021@berijam.com");
		ExtentListeners.test.log(Status.INFO, "Entering name");
		values("UserPassword_XPATH", "Test123$");
		click("SignIn_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("FirmUser"))));
	}

	@Test(priority = 1)
	public void signup() {

		values("Firstname_XPATH", "Test2");
		values("Lasttname_XPATH", "Live");
		values("Email_XPATH", "rain" + random.nextLong() + "@berijam.com");
		values("Password_XPATH", "Test123$");
		click("signup_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("Welcome_XPATH"))));
		values("Businessname_XPATH", "Auto Test");
		values("Businessphone_XPATH", "9876543210");
		click("Businesscag_XPATH");
		click("BusinessCagVal_XPATH");
		click("Country_XPATH");
		click("CountryValue_XPATH");
		click("Timezone_XPATH");
		click("TimezoneValue_XPATH");
		click("User_XPATH");
		click("Demo_XPATH");
		click("Started_XPATH");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("Tooltip_XPATH"))));
		click("TooltipSkip_XPATH");
	}

	// PayPal payment

	@Test(priority = 9)
	public void StarterToLite() {
		click("Expand_XPATH");
		click("Manage_Account_XPATH");
		// Thread.sleep(1500);

		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Upgrade_Clickable_XPATH"))));
		click("Upgrade_XPATH");
		click("Plan_Next_XPATH");
		values("Licence_Count_XPATH", "3");
		click("Licences_Next_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("PayPal_Pay_XPATH");
		paypayDetailsLogin();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		paypalDetails();

	}

	@Test(priority = 10)
	public void LiteToPremiumPaypal() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Premium_XPATH"))));
		click("Premium_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));

		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");

		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		addAndReducePaypal();

	}

	@Test(priority = 11)
	public void PremiumToUltimatePaypal() {
		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Ultimate_XPATH"))));
		click("Ultimate_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");
		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		addAndReducePaypal();

	}

	@Test(priority = 12)
	public void UltimateToPremiumPaypal() {

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Premium_XPATH"))));
		click("Premium_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");
		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		// addAndReducePaypal();

	}

	@Test(priority = 13)
	public void PremiumToLitePaypal() {

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Lite_XPATH"))));
		click("Lite_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");
		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		addAndReducePaypal();
	}

	@Test(priority = 14)
	public void LiteToUltimatePaypal() {

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Ultimate_XPATH"))));
		click("Ultimate_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");
		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		// addAndReducePaypal();
	}

	@Test(priority = 15)
	public void UltimateToLitePaypal() {

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Lite_XPATH"))));
		click("Lite_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement palpay = driver.findElement(By.xpath(variables.getProperty("PayPal_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", palpay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))));
		click("PayPal_Pay_XPATH");
		isElementPresent("PayPal_Pay_XPATH");
		paypalDetails();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		// addAndReducePaypal();
	}

	@Test(priority = 16)
	public void LitetoStarter() {

		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Starter_XPATH"))));
		click("Starter_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("DownGrade_XPATH"))));
		isElementPresent("DownGrade_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("Account_Popup_XPATH");

	}

}
