
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PromoModule extends StringValues{
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/marvin/eclipse-workspace/checkingServerStatus/libs/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://172.16.0.19/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest() throws Exception {
		toLogin();
		if (driver.getPageSource().contains("Promo") && (driver.getPageSource().contains("Wallet"))){
			System.out.println("Login Test pass");
		}
	}

	@Test
	public void createMany() throws Exception {
		for (int i = 0; i < 20; i++) {
			createPromoFoodBev();
			String FoodBev = "Food & Beverage";
			createPromoRetail();
			String Retail = "Retail";
			createPromoEvents();
			String Events = "Events";
			createPromoLifestyle();
			String Lifestyle = "Lifestyle";
			createPromoTravelTours();
			String Tours = "Travel & Tours";
			createPromoServices();
			String Services = "Services";
			System.out.println(FoodBev+ " "+ Retail + " " + Events+ " " 
					+Lifestyle + " "+Tours + " " + Services +" qa pass " + i);
			
		}
		
	}
	
	@Test 
	public void createPromoFoodBev() throws Exception {
		toLogin();
		//		skipHelp();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		new Select(driver.findElement(By.id(selectCategory))).selectByVisibleText("Food and Beverage");
		driver.findElement(By.id("file")).sendKeys(foodBevIMG);
		savePromo();
		
	}

	@Test
	public void createPromoRetail() throws Exception {
		toLogin();
		//		skipHelp();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		driver.findElement(By.id("file")).sendKeys(retailIMG);
		new Select(driver.findElement(By.id("promoCategory"))).selectByVisibleText("Retail");
		savePromo();
	}
	
	
	@Test
	public void createPromoEvents() throws Exception {
		toLogin();
		//		skipHelp();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		driver.findElement(By.id("file")).sendKeys(eventsIMG);
		new Select(driver.findElement(By.id("promoCategory"))).selectByVisibleText("Events");
		savePromo();
	}

	@Test
	public void createPromoLifestyle() throws Exception {
		toLogin();
		//		skipHelp();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		driver.findElement(By.id("file")).sendKeys(lifestyleIMG);
		new Select(driver.findElement(By.id("promoCategory"))).selectByVisibleText("Lifestyle");
		savePromo();
	}
	@Test
	public void createPromoServices() throws Exception {
		toLogin();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		driver.findElement(By.id("file")).sendKeys(servicesIMG);
		new Select(driver.findElement(By.id("promoCategory"))).selectByVisibleText("Services");
		savePromo();
	}

	@Test
	public void createPromoTravelTours() throws Exception {
		toLogin();
		toNewPromo();
		Thread.sleep(1000);
		skipHelp();
		setPromoDetails();
		driver.findElement(By.id("file")).sendKeys(travelToursIMG);
		new Select(driver.findElement(By.id("promoCategory"))).selectByVisibleText("Tours and Travels");
		savePromo();
	}

	private void savePromo() {
		driver.findElement(By.xpath(btnSavePromo)).click();

	}
	
	private void setPromoDetails() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(promoTitleField)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
		driver.findElement(By.xpath(promoDescField)).sendKeys(RandomStringUtils.randomAlphanumeric(200));
		driver.findElement(By.id(selectEndDate)).click();
		driver.findElement(By.linkText(selectDate)).click();
		driver.findElement(By.xpath(categoryDropdown)).click();
		
	}


	public void toNewPromo() {
		driver.findElement(By.xpath(bntCrtePromo)).click();
	}

	public void skipHelp() {
		if (driver.getPageSource().contains("Skip")) {
			driver.findElement(By.xpath(btnSKIP)).click();
		}
	}


	public void toLogin() {
//		driver.get(baseUrl);
		driver.findElement(By.name(uNameField)).sendKeys(AuthUname);
		driver.findElement(By.name(passField)).sendKeys(AuthPass);
		driver.findElement(By.xpath(btnLogin)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
