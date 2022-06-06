package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.AppBase;
import Extent.ExtentListeners;

public class Create_Activities extends AppBase {

	public static void anetPaymentDetails() {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(variables.getProperty("Card_Number_CSS"))));
		values("Card_Number_CSS", "4111111111111111");
		click("Card_Date_XPATH");
		click("Card_Setdate_XPATH");
		click("Card_Year_XPATH");
		click("Card_Yearset_XPATH");
		values("Cvv_XPATH", "123");
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

	/*
	 * @Test(priority = 1) public void Login() throws InterruptedException {
	 * 
	 * values("UserEmail_XPATH", "sir05@berijam.com");
	 * ExtentListeners.test.log(Status.INFO, "Enterning name");
	 * values("UserPassword_XPATH", "Test123$"); click("SignIn_XPATH");
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(variables.
	 * getProperty("FirmUser")))); }
	 */
	@Test(priority = 1)
	public void signup() {

		values("Firstname_XPATH", "Test2");
		values("Lasttname_XPATH", "Live"); //
		values("Email_XPATH", "rain" + random.nextInt() + "@berijam.com");
		// values("Email_XPATH", "ran57@berijam.com");
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
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id is: " + s);
	}

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

		click("Apptio_Home_CSS");

	}
}


