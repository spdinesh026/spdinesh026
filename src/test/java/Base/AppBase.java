package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;

import Extent.ExtentListeners;
import Utilities.ExcelReader;
import Utilities.MonitoringMail;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppBase {

	public static WebDriver driver;
	public static Properties variables = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(AppBase.class);
	// public static WebDriverWait wait;
	public static Wait<WebDriver> wait;
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/Testdata.xlsx");
	public static MonitoringMail mail = new MonitoringMail();
	public static JavascriptExecutor j = (JavascriptExecutor) driver;
	public static Random random = new Random();

	// public Actions action = new Actions(driver);
	// public static WebElement changePlan =
	// driver.findElement(By.xpath(variables.getProperty("Change_Plan_XPATH"))) ;

	@BeforeTest
	public void setup() {

		PropertyConfigurator.configure("./src/test/resources/Properties/log4j.properties");
		log.info("Test execution started");

		if (driver == null) {
			try {
				fis = new FileInputStream("./src/test/resources/Properties/variables.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				variables.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream("./src/test/resources/Properties/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		  WebDriverManager.chromedriver().setup();
		  
		  driver = new ChromeDriver();
		  
		   driver.get(config.getProperty("signupurl"));
		 // driver.get(config.getProperty("testsiteurl"));
		  driver.manage().window().maximize(); driver.manage().timeouts()
		  .implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty(
		  "implicit.wait")))); // wait = new WebDriverWait(driver,		  Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		  
		  wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).
		  pollingEvery(Duration.ofSeconds(5)) .ignoring(NoSuchElementException.class);
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 

	}

	public static void click(String key) {

		if (key.endsWith("_XPATH")) {

			driver.findElement(By.xpath(variables.getProperty(key))).click();

		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(variables.getProperty(key))).click();
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(variables.getProperty(key))).click();
		} else if (key.endsWith("_NAME")) {
			driver.findElement(By.name(variables.getProperty(key))).click();
		}

		log.info("Clicking on : " + key);
		ExtentListeners.test.log(Status.INFO, "Clicking on " + key);

	}

	public static void values(String key, String value) {

		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(variables.getProperty(key))).sendKeys(value);

		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(variables.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(variables.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_NAME")) {
			driver.findElement(By.name(variables.getProperty(key))).sendKeys(value);
		}
		log.info("Typing in" + key);
		ExtentListeners.test.log(Status.INFO, "Typing " + key);
	}

	public static boolean isElementPresent(String key) {

		try {
			if (key.endsWith("_XPATH")) {

				driver.findElement(By.xpath(variables.getProperty(key))).click();

			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(variables.getProperty(key))).click();
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(variables.getProperty(key))).click();
			} else if (key.endsWith("_NAME")) {
				driver.findElement(By.name(variables.getProperty(key))).click();
			}

			log.info("Clicking on : " + key);
			ExtentListeners.test.log(Status.INFO, "Clicking on " + key);

			return true;
		} catch (Throwable t) {

			log.info("Error while finding the Element : " + key);
			ExtentListeners.test.log(Status.INFO, "Error while finding the Element :" + key);

			return false;
		}
	}

	public static boolean isElementPresent(String key, String value) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(variables.getProperty(key))).sendKeys(value);

			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(variables.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(variables.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_NAME")) {
				driver.findElement(By.name(variables.getProperty(key))).sendKeys(value);
			}
			log.info("Typing in" + key);
			ExtentListeners.test.log(Status.INFO, "Typing " + key);

			return true;
		} catch (Throwable t) {

			log.info("Error while finding the Element : " + key);
			ExtentListeners.test.log(Status.INFO, "Error while finding the Element :" + key);

			return false;
		}
	}

	@AfterTest
	public void teardown() {
		// mail.sendMail(TestConfig.server,TestConfig.from, TestConfig.to,
		// TestConfig.subject, TestConfig.messageBody,
		// TestConfig.attachmentPath,TestConfig.attachmentName);
		 driver.quit();

	}
}