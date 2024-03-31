package ramrajcott;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpracrep {
	@FindBy(xpath= "//*[@id=\\\"shopify-section-sections--17427954368738__header\\\"]/section/header/div/div/div[2]/div[3]/div/a[2]")
	public static WebElement myaccount;
	@FindBy(xpath = "//*[@id ='customer[email]']")
	public static WebElement email;
	@FindBy(xpath = "//*[@id ='customer[password]']")
	public static WebElement passwd;
	@FindBy(xpath="//*[@id=\"customer_login\"]/button")
	public static WebElement login_btn;
	
}
