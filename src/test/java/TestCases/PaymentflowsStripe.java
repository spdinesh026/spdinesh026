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

public class PaymentflowsStripe extends AppBase {

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Licenses_Number_XPATH"))));
		values("Licenses_Number_XPATH", "3");
		click("AddLicenses_rough_XPATH");
		click("Reduce_Button_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		// wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(variables.getProperty("Licenses_Reduced_Success_CSS")),"3
		// License(s) reduced."));

	}

	public void addAndReduceStripe() {
		addLicences();
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))))
				.click();
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));

		click("Card_Confirm_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		reduceLicences();

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Ultimate_XPATH"))));

	}

	public void Login() {

		values("UserEmail_XPATH", "random020@berijam.com");
		ExtentListeners.test.log(Status.INFO, "Entering name");
		values("UserPassword_XPATH", "Test123$");
		click("SignIn_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("FirmUser"))));
	}

	@Test(priority = 1)
	public void signup() {

		values("Firstname_XPATH", "Test2");
		values("Lasttname_XPATH", "stripe");
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("Tooltip_XPATH"))));
		click("TooltipSkip_XPATH");
	}

	// stripe payment

	@Test(priority = 2)
	public void starterToLite() throws InterruptedException {

		click("Expand_XPATH");
		click("Manage_Account_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("Upgrade_XPATH");
		click("Plan_Next_XPATH");
		values("Licence_Count_XPATH", "3");
		click("Licences_Next_XPATH");

		click("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));

		click("Card_Confirm_XPATH");

		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

	}

	// public WebElement changePlan = //
	// driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH"))) ;

	@Test(priority = 3)
	public void LiteToPremium() {

		/*
		 * click("Expand_XPATH"); click("Manage_Account_XPATH"); Thread.sleep(2000);
		 */
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);
		click("Change_Plan_XPATH");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Premium_XPATH"))));
		click("Premium_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		addAndReduceStripe();

	}

	@Test(priority = 4)
	public void PremiumToUltimate() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Ultimate_XPATH"))));

		click("Ultimate_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		addAndReduceStripe();

	}

	@Test(priority = 5)
	public void UltimateToPremium() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Premium_XPATH"))));
		click("Premium_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		// addAndReduceStripe();
	}

	@Test(priority = 6)
	public void PremiumToLite() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Lite_XPATH"))));
		click("Lite_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		addAndReduceStripe();
	}

	@Test(priority = 7)
	public void LiteToUltimate() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Ultimate_XPATH"))));
		click("Ultimate_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		// addAndReduceStripe();
	}

	@Test(priority = 8)
	public void UltimateToLite() {
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		WebElement changePlan = driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changePlan);

		click("Change_Plan_XPATH");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Lite_XPATH"))));
		click("Lite_XPATH");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(variables.getProperty("AddLicenses_present_XPATH"))));

		WebElement stripepay = driver.findElement(By.xpath(variables.getProperty("Stripe_Pay_XPATH")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stripepay);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Stripe_Pay_XPATH"))));
		click("Stripe_Pay_XPATH");
		isElementPresent("Stripe_Pay_XPATH");
		anetPaymentDetails();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Card_Confirm_XPATH"))));
		click("Card_Confirm_XPATH");
		click("Account_Popup_XPATH");
		isElementPresent("Card_Confirm_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));

		// addAndReduceStripe();
	}

	@Test(priority = 9)
	public void ChangeCreditCard() {

		click("ChangeCreditCard_XPATH");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(variables.getProperty("Card_Number_CSS"))));
		values("Card_Number_CSS", "4111111111111111");
		click("Card_Date_XPATH");
		click("Card_Setdate_XPATH");
		click("Card_Year_XPATH");
		click("Card_Yearset_XPATH");
		values("Cvv_XPATH", "123");
		click("CCCUpgrade_XPATH");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath(variables.getProperty("ProgressBar_XPATH"))));
		click("CCCSuccess_XPATH");
	}

	@Test(priority = 16)
	public void LitetoStarter() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(variables.getProperty("Change_Plan_XPATH"))));

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
