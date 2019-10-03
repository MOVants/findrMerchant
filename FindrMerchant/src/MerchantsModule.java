
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MerchantsModule {
	public  WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/marvin/eclipse-workspace/PageObaandFactory/libs/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://172.16.0.19/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void createMerTest() throws Exception {
		PromoModule getLogin = new PromoModule();
		Thread.sleep(2000);
		getLogin.toLogin();
		toLogin();
		navtoMerchant();
		addNewMerchant();
		setMerchantDetails();
		saveMerchant();
		Thread.sleep(5000);


		if (driver.getPageSource().contains("Promo") && (driver.getPageSource().contains("Wallet"))){
			System.out.println("Create Merchant Test pass");
		}else {

			System.out.println("Create merchant Test Failed");
		}
	}

	@Test
	public void createMerMissingNameTest() throws Exception {

		//		toLogin();
		navtoMerchant();
		if (driver.getPageSource().contains("Skip")) {
			driver.findElement(By.xpath("//div[text()='Skip']")).click();
		}else {
			addNewMerchant();
		}
		addNewMerchant();
		setMerchantDetails();
		driver.findElement(By.xpath("//input[@type='text'][@name='name']")).clear();
		saveMerchant();
		Thread.sleep(5000);


		if (driver.getPageSource().contains("This is a required field") && (driver.getPageSource().contains("Branch"))){
			System.out.println("Create Merchant Missing name Test pass");

		}else {

			System.out.println("Create merchant missing Test Failed");
		}
	}

	private void saveMerchant() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

	private void setMerchantDetails() {
		driver.findElement(By.xpath("//input[@type='text'][@name='name']")).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.xpath("//input[@type='text'][@name='email']")).sendKeys(RandomStringUtils.randomNumeric(6)+"."+RandomStringUtils.randomNumeric(6)+"@"+RandomStringUtils.randomNumeric(4)+".com");
		driver.findElement(By.xpath("//select[@name='info.branch.id']")).click();
		new Select(driver.findElement(By.id("branches"))).selectByIndex(2);


	}

	private void addNewMerchant() {
		driver.findElement(By.xpath("//a[contains(text(),'New')]")).click();

	}

	public void navtoMerchant() {
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Promos'])[1]/following::span[1]")).click();

	}


	public void toLogin() {
		driver.get(baseUrl);
		driver.findElement(By.name(uNameField)).sendKeys(AuthUname);
		driver.findElement(By.name(passField)).sendKeys(AuthPass);
		driver.findElement(By.xpath(btnLogin)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
