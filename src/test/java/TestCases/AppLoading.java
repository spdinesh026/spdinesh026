package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.AppBase;
import Extent.ExtentListeners;

public class AppLoading extends AppBase {

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		values("UserEmail_XPATH", "ring-uk@berijam.com");
		ExtentListeners.test.log(Status.INFO, "Enterning name");
		values("UserPassword_XPATH", "Welcome@123");
		click("SignIn_XPATH");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(variables.getProperty("FirmUser"))));
	}

	@Test(priority = 2)
	public void Home() {
		driver.get(config.getProperty("Home"));
		ExtentListeners.test.log(Status.INFO, "Navigating to Home");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "MY AGENDA";
		Assert.assertEquals(expectedresult, actualresult);

	}

	@Test(priority = 3)
	public void Emails() {
		driver.get(config.getProperty("emailsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to EmailsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "EMAILS";
		Assert.assertEquals(expectedresult, actualresult);

	}

	@Test(priority = 4)
	public void EmployeesApp() {
		driver.get(config.getProperty("EmployeesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to EmployeesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "EMPLOYEES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 5)
	public void Globalsearch() {
		driver.get(config.getProperty("GlobalSearch"));
		ExtentListeners.test.log(Status.INFO, "Navigating to GlobalSearch");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SEARCH RESULTS";
		Assert.assertEquals(expectedresult, actualresult);

	}

	@Test(priority = 6)
	public void AnswersApp() {
		driver.get(config.getProperty("AnswersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to AnswersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "ANSWERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 7)
	public void CampaignsApp() {
		driver.get(config.getProperty("CampaignsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CampaignsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CAMPAIGNS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 8)
	public void CandidatesApp() {
		driver.get(config.getProperty("CandidatesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CandidatesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CANDIDATES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 9)
	public void CasesApp() {
		driver.get(config.getProperty("CasesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CasesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CASES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 10)
	public void CashmanagementApp() {
		driver.get(config.getProperty("CashmanagementApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CashmanagementApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CASH MANAGEMENT";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 11)
	public void CompetitorsApp() {
		driver.get(config.getProperty("CompetitorsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CompetitorsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "COMPETITORS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 12)
	public void ContactcenterApp() {
		driver.get(config.getProperty("ContactcenterApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ContactcenterApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CONTACT CENTER";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 13)
	public void ContactsApp() {
		driver.get(config.getProperty("ContactsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ContactsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CONTACTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 14)
	public void PartnersApp() {
		driver.get(config.getProperty("PartnersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PartnersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertPartner"))).getText();
		String expectedresult = "Partners";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 15)
	public void DocumentsApp() {
		driver.get(config.getProperty("DocumentsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to DocumentsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertDocument"))).getText();
		String expectedresult = "DOCUMENTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 16)
	public void FeedbackApp() {
		driver.get(config.getProperty("FeedbackApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to FeedbackApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertFeedback"))).getText();
		String expectedresult = "FEEDBACK";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 17)
	public void ContractsApp() {
		driver.get(config.getProperty("ContractsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ContractsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CONTRACTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 18)
	public void CreditnotesApp() {
		driver.get(config.getProperty("CreditnotesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CreditnotesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CREDIT NOTES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 19)
	public void CrninsightsApp() {
		driver.get(config.getProperty("CrninsightsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CrninsightsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CUSTOMER REGULATORY NOTIFICATION ANALYTICS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 20)
	public void CrnApp() {
		driver.get(config.getProperty("CrnApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CrnApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CUSTOMER REGULATORY NOTIFICATIONS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 21)
	public void CustomerpaymentsApp() {
		driver.get(config.getProperty("CustomerpaymentsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CustomerpaymentsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CUSTOMER PAYMENTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 22)
	public void CustomersApp() {
		driver.get(config.getProperty("CustomersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to CustomersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "CUSTOMERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 23)
	public void DirectcampaignsApp() {
		driver.get(config.getProperty("DirectcampaignsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to DirectcampaignsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "DIRECT CAMPAIGNS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 24)
	public void DistributorsApp() {
		driver.get(config.getProperty("DistributorsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to DistributorsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "DISTRIBUTORS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 25)
	public void EstimatesApp() {
		driver.get(config.getProperty("EstimatesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to EstimatesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "ESTIMATES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 26)
	public void ExpensereportsApp() {
		driver.get(config.getProperty("ExpensereportsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ExpensereportsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "EXPENSE REPORTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 27)
	public void FixedassetsApp() {
		driver.get(config.getProperty("FixedassetsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to FixedassetsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "FIXED ASSETS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 28)
	public void FundraisingApp() {
		driver.get(config.getProperty("FundraisingApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to FundraisingApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "FUND RAISING";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 29)
	public void HolidaysApp() {
		driver.get(config.getProperty("HolidaysApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to HolidaysApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "HOLIDAYS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 30)
	public void IdeasApp() {
		driver.get(config.getProperty("IdeasApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to IdeasApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "IDEAS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 31)
	public void InstalledbaseApp() {
		driver.get(config.getProperty("InstalledbaseApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to InstalledbaseApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "INSTALLED BASE";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 32)
	public void InsurancetrackerApp() {
		driver.get(config.getProperty("InsurancetrackerApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to InsurancetrackerApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "INSURANCE TRACKER";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 33)
	public void InventorymanagementApp() {
		driver.get(config.getProperty("InventorymanagementApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to InventorymanagementApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "INVENTORY MANAGEMENT";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 34)
	public void InvoiceApp() {
		driver.get(config.getProperty("InvoiceApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to InvoiceApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "INVOICE";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 35)
	public void ItemsApp() {
		driver.get(config.getProperty("ItemsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ItemsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "ITEMS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 36)
	public void KitordersApp() {
		driver.get(config.getProperty("KitordersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to KitordersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "KIT ORDERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 37)
	public void LeadsApp() {
		driver.get(config.getProperty("LeadsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to LeadsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "LEADS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 38)
	public void LedgerApp() {
		driver.get(config.getProperty("LedgerApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to LedgerApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "LEDGER";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 39)
	public void LicensetrackerApp() {
		driver.get(config.getProperty("LicensetrackerApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to LicensetrackerApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "LICENSE TRACKER";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 40)
	public void MovetransactionsApp() {
		driver.get(config.getProperty("MovetransactionsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to MovetransactionsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "MOVE TRANSACTIONS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 41)
	public void NotesApp() {
		driver.get(config.getProperty("NotesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to NotesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "NOTES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 42)
	public void OpportunitiesApp() {
		driver.get(config.getProperty("OpportunitiesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to OpportunitiesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "OPPORTUNITIES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 43)
	public void OrdersApp() {
		driver.get(config.getProperty("OrdersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to OrdersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "ORDERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 44)
	public void PatentsApp() {
		driver.get(config.getProperty("PatentsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PatentsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PATENTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 45)
	public void PricingApp() {
		driver.get(config.getProperty("PricingApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PricingApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PRICING";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 46)
	public void ProjectsApp() {
		driver.get(config.getProperty("ProjectsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ProjectsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PROJECTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 47)
	public void PromotionsApp() {
		driver.get(config.getProperty("PromotionsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PromotionsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PROMOTIONS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 48)
	public void PropertiesApp() {
		driver.get(config.getProperty("PropertiesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PropertiesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PROPERTIES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 49)
	public void PurchaseordersApp() {
		driver.get(config.getProperty("PurchaseordersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PurchaseordersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PURCHASE ORDERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 50)
	public void PurchaserequisitionsApp() {
		driver.get(config.getProperty("PurchaserequisitionsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to PurchaserequisitionsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "PURCHASE REQUISITIONS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 51)
	public void ReceivingApp() {
		driver.get(config.getProperty("ReceivingApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ReceivingApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "RECEIVING";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 52)
	public void RecruitmentsApp() {
		driver.get(config.getProperty("RecruitmentsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to RecruitmentsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "RECRUITMENT";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 53)
	public void SalesplanningApp() {
		driver.get(config.getProperty("SalesplanningApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to SalesplanningApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SALES PLANNING";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 54)
	public void SalesreceiptsApp() {
		driver.get(config.getProperty("SalesreceiptsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to SalesreceiptsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SALES RECEIPTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 55)
	public void ShippingApp() {
		driver.get(config.getProperty("ShippingApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to ShippingApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SHIPPING";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 56)
	public void SupplierinvoicesApp() {
		driver.get(config.getProperty("SupplierinvoicesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to SupplierinvoicesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SUPPLIER INVOICES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 57)
	public void SupplierpaymentsApp() {
		driver.get(config.getProperty("SupplierpaymentsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to SupplierpaymentsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SUPPLIER PAYMENTS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 58)
	public void SuppliersApp() {
		driver.get(config.getProperty("SuppliersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to SuppliersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "SUPPLIERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 59)
	public void TargetsApp() {
		driver.get(config.getProperty("TargetsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TargetsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TARGETS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 60)
	public void TeamsApp() {
		driver.get(config.getProperty("TeamsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TeamsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TEAMS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 61)
	public void TerritoriesApp() {
		driver.get(config.getProperty("TerritoriesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TerritoriesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TERRITORY MANAGEMENT";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 62)
	public void TestcyclesApp() {
		driver.get(config.getProperty("TestcyclesApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TestcyclesApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TEST CYCLES";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 63)
	public void TestimonialsApp() {
		driver.get(config.getProperty("TestimonialsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TestimonialsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TESTIMONIALS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 64)
	public void TimesheetsApp() {
		driver.get(config.getProperty("TimesheetsApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to TimesheetsApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "TIMESHEETS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 65)
	public void WorkordersApp() {
		driver.get(config.getProperty("WorkordersApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to WorkordersApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "WORK ORDERS";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 66)
	public void MiscellaneousissueApp() {
		driver.get(config.getProperty("MiscellaneousissueApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to MiscellaneousissueApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "MISCELLANEOUS ISSUE";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 67)
	public void MiscellaneousreceiptApp() {
		driver.get(config.getProperty("MiscellaneousreceiptApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to MiscellaneousreceiptApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "MISCELLANEOUS RECEIPT";
		Assert.assertEquals(expectedresult, actualresult);
	}

	@Test(priority = 68)
	public void LoyaltymanagementApp() {
		driver.get(config.getProperty("LoyaltymanagementApp"));
		ExtentListeners.test.log(Status.INFO, "Navigating to LoyaltymanagementApp");
		String actualresult = driver.findElement(By.cssSelector(config.getProperty("assertApp"))).getText();
		String expectedresult = "LOYALTY MANAGEMENT";
		Assert.assertEquals(expectedresult, actualresult);
	}
}
