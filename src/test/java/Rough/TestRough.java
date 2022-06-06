package Rough;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.AppBase;
import Extent.ExtentListeners;

public class TestRough extends AppBase {

	public static void anetPaymentDetails() {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(variables.getProperty("Card_Number_CSS"))));
		values("Card_Number_CSS", "4111111111111111");
		isElementPresent("Card_Date_XPATH");
		isElementPresent("Card_Setdate_XPATH");
		isElementPresent("Card_Year_XPATH");
		isElementPresent("Card_Yearset_XPATH");
		isElementPresent("Cvv_XPATH", "123");
		values("Card_Firstname_XPATH", "Automate");
		values("Card_Lastname_XPATH", "Test");
		values("Card_Address1_CSS", "madurai");
		values("Card_Address2_CSS", "madurai");
		values("Card_City_XPATH", "madurai");
		click("Card_state_CSS");
		click("Card_stateselect_XPATH");
		values("Card_Zipcode_XPATH", "656545");
		click("Card_Payment_XPATH");
	}

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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licenses_Number_XPATH"))))
				.sendKeys("3");
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licenses_Number_XPATH"))))
				.sendKeys("3");
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("PayPal_Pay_XPATH"))))
				.click();
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

	
	  @Test(priority = 1) public void Login() {
	  
	  values("UserEmail_XPATH", "knatrayan@apptivo.co.in");
	  ExtentListeners.test.log(Status.INFO, "Entering name");
	  values("UserPassword_XPATH", "Test123$"); click("SignIn_XPATH");
	  click("Temp_XPATH");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.
	  getProperty("FirmUser")))); }
	 
	/*
	 * @Test(priority = 1) public void signup() {
	 * 
	 * values("Firstname_XPATH", "Test2"); values("Lasttname_XPATH", "Live");
	 * values("Email_XPATH", "rain" + random.nextLong() +"@berijam.com");
	 * //values("Email_XPATH", "cfc03@berijam.com"); values("Password_XPATH",
	 * "Test123$"); click("signup_XPATH");
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.
	 * getProperty("Welcome_XPATH")))); values("Businessname_XPATH", "Auto Test");
	 * values("Businessphone_XPATH", "9876543210"); click("Businesscag_XPATH");
	 * click("BusinessCagVal_XPATH"); click("Country_XPATH");
	 * click("CountryValue_XPATH"); click("Timezone_XPATH");
	 * click("TimezoneValue_XPATH"); click("User_XPATH"); click("Demo_XPATH");
	 * click("Started_XPATH");
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	 * 
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.
	 * getProperty("Tooltip_XPATH")))); click("TooltipSkip_XPATH");
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 2) public void starterToLite() throws InterruptedException {
	 * 
	 * click("Expand_XPATH"); click("Manage_Account_XPATH");
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables
	 * .getProperty("ProgressBar_XPATH")))); click("Upgrade_XPATH");
	 * click("Plan_Next_XPATH"); values("Licence_Count_XPATH", "3");
	 * click("Licences_Next_XPATH");
	 * 
	 * click("Stripe_Pay_XPATH"); anetPaymentDetails();
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.
	 * getProperty("Card_Confirm_XPATH"))));
	 * 
	 * click("Card_Confirm_XPATH");
	 * 
	 * click("Account_Popup_XPATH"); isElementPresent("Card_Confirm_XPATH");
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables
	 * .getProperty("ProgressBar_XPATH"))));
	 * 
	 * }
	 * 
	 * @Test(priority = 3, invocationCount = 5) public void add_licences() {
	 * 
	 * 
	 * addLicences(); wait.until(
	 * ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.
	 * getProperty("ProgressBar_XPATH"))));
	 * 
	 * WebElement stripepay =
	 * driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.
	 * getProperty("Stripe_Pay_XPATH")))) .click();
	 * isElementPresent("Stripe_Pay_XPATH"); anetPaymentDetails();
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.
	 * getProperty("Card_Confirm_XPATH"))));
	 * 
	 * click("Card_Confirm_XPATH"); isElementPresent("Card_Confirm_XPATH");
	 * wait.until(
	 * ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.
	 * getProperty("ProgressBar_XPATH")))); }
	 */

	/*
	 * @Test(priority =3) public void ChangeCreditCard() {
	 * 
	 * click("ChangeCreditCard_XPATH");
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
	 * variables.getProperty("Card_Number_CSS")))); values("Card_Number_CSS",
	 * "4111111111111111"); click("Card_Date_XPATH"); click("Card_Setdate_XPATH");
	 * click("Card_Year_XPATH"); click("Card_Yearset_XPATH"); values("Cvv_XPATH",
	 * "123"); click("CCCUpgrade_XPATH");
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables
	 * .getProperty("ProgressBar_XPATH")))); click("CCCSuccess_XPATH");
	 * 
	 * }
	 * 
	 */

	@Test(priority = 2)
	public static void livedata() {

		int live[] = { 264487 };

		int firm = live.length;

	for (int i = 0; i <firm; i++) {
			
			  driver.get(
			  "https://staging.apptivo.net/app/dao/appcfgupdate?a=verifyFirm&frmId=" +
			  live[i] + "&iase=Y&ivf=Y");
			 
			
			System.out.println(live[i]);
		}
	}

}
