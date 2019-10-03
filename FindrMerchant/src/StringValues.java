import org.apache.commons.lang3.RandomStringUtils;

public class StringValues {
	
	protected String randomAlphaNumChar = RandomStringUtils.randomAlphabetic(10);
	protected String randomAlphaChar = RandomStringUtils.randomAlphabetic(6);
	protected String randomNumChar = RandomStringUtils.randomAlphabetic(11);

	//Auth
	protected String AuthUname = "altair@satellite.com.ph";
	protected String AuthPass = "1";

	//Login
	protected String uNameField = "username";
	protected String passField = "password";
	protected String btnLogin = "//button[text()='Log In']";


	// Help
	protected String btnSKIP = "//div[text()='Skip']";


	//	Home


	// Promos MNGT
	protected String bntCrtePromo = "//a[contains(text(),'New Promo')]";

	//	Create promo
	protected String promoTitleField = "//input[@type='text'][@name='promoDto.title']";
	protected String promoDescField = "//textarea[@name='promoDto.description']";
	protected String btnExpiryDate = "(.//*[normalize-space(text()) and normalize-space(.)='End Date'])[1]/following::span[1]";
	protected String btnExpiryDateCal = "(.//*[normalize-space(text()) and normalize-space(.)='End Date'])[1]/following::span[1]";
	protected String selectEndDate = "enddate";
	protected String selectDate = "30";
	protected String categoryDropdown = "//select[@name='promoDto.promoCategory']";
	protected String selectCategory = "promoCategory";



	//Save Promo
	protected String btnSavePromo = "//button[text()='Save']";

	//Upload File Image
	protected String travelToursIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/travels.jpg";
	protected String foodBevIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/Food.jpg";
	protected String eventsIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/events.jpg";
	protected String retailIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/retail.jpg";
	protected String servicesIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/services.jpg";
	protected String lifestyleIMG = "/home/marvin/eclipse-workspace/FindrMerchant/libs/imgSrc/lifestyle.jpg";

}
