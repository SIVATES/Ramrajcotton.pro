package ramrajcott;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DataDriven {
	private static ExtentSparkReporter sparkRepoter;
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	@BeforeTest
	void init()
	{
		WebDriverManager.edgedriver().setup();
		extent = new ExtentReports();
		sparkRepoter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\testResult.html");
		extent.attachReporter(sparkRepoter);
		
		sparkRepoter.config().setOfflineMode(true);
		sparkRepoter.config().setDocumentTitle("Automation Report");
		sparkRepoter.config().setReportName("Test Report");
		sparkRepoter.config().setTheme(Theme.STANDARD);
		sparkRepoter.config().setTimeStampFormat("EEEE, MMM dd, yyyy , hh:mm a'('zzz')'");
		sparkRepoter.config().setEncoding("UTF-8");
		
		 driver = new EdgeDriver();
		 driver.manage().window().maximize();
}

	@Test(priority=1)
	@Parameters({"email","passwd"})
void Login(String email1,String passwd1) throws InterruptedException
{
		extentTest = extent.createTest("login page");
		extentTest.log(Status.INFO, "starting test:" + extent.getStats());
		extentTest.assignCategory("S");
		try
		{
		driver.get("https://ramrajcotton.in/");
		driver.manage().window().maximize();	
		Actions act = new Actions(driver);
		WebElement myaccount = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--17427954368738__header\"]/section/header/div/div/div[2]/div[3]/div/a[2]"));
	act.moveToElement(myaccount).click().build().perform();
	PageFactory.initElements(driver,Loginpracrep.class);

	Loginpracrep.email.sendKeys(email1);
	Loginpracrep.passwd.sendKeys(passwd1);
	Loginpracrep.login_btn.click();
	Thread.sleep(3000);
         
    	  Actions act1 = new Actions(driver);
    	  WebElement MEN = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--17427954368738__header\"]/section/nav/div/div/ul/li[1]/a"));
    	  act1.moveToElement(MEN).click().build().perform();
    	 Thread.sleep(3000);
    	
    	 
    	 Actions buy = new Actions(driver);
    	 WebElement Culture = driver.findElement(By.xpath("//*[@id=\"shopify-section-template--17427956891874__main\"]/section/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/a/div/img[1]"));
         buy.moveToElement(Culture).doubleClick().build().perform();
         Thread.sleep(3000);
        
         
         Actions ADDCART = new Actions(driver);
         WebElement CART = driver.findElement(By.xpath("//*[@id=\"product_form_template--17427957743842__main7967810322658\"]/div[7]/div/button"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", CART);
         ADDCART.click(CART).build().perform();
         Thread.sleep(3000); 
         
    	  Actions act2 = new Actions(driver);
    	 WebElement silk = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--17427954368738__header\"]/section/nav/div/div/ul/li[2]/a"));
    	 act2.moveToElement(silk).click().build().perform();
    	 Thread.sleep(3000);
    	 
    	 Actions buy1 = new Actions(driver);
    	 WebElement Shirt = driver.findElement(By.xpath("//*[@id=\"shopify-section-template--17427956891874__main\"]/section/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/a/div/img[2]"));
         buy1.moveToElement(Shirt).doubleClick().build().perform();
         Thread.sleep(3000);
         
         Actions ADDCART2 = new Actions(driver);
         WebElement CART2 = driver.findElement(By.xpath("//*[@id=\"product_form_template--17427957743842__main4361802448943\"]/div[7]/div/button"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", CART2);
         ADDCART2.click(CART2).build().perform();
         Thread.sleep(3000);
         
         Actions act3 = new Actions(driver);
    	 WebElement fabrics = driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--17427954368738__header\"]/section/nav/div/div/ul/li[3]/a"));
    	 act3.moveToElement(fabrics).click().build().perform();
    	 Thread.sleep(3000);
    	 
    	 Actions buy2 = new Actions(driver);
    	 WebElement PShirt = driver.findElement(By.xpath("//*[@id=\"shopify-section-template--17427956891874__main\"]/section/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/a/div/img[1]"));
         buy2.moveToElement(PShirt).doubleClick().build().perform();
         Thread.sleep(3000);
         
         Actions ADDCART3 = new Actions(driver);
         WebElement CART3 = driver.findElement(By.xpath("//*[@id=\"product_form_template--17427957743842__main8248914116834\"]/div[6]/div/button"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", CART3);
         ADDCART2.click(CART3).build().perform();
         Thread.sleep(3000);
         
}catch(Exception ex) {
	extentTest.log(Status.FAIL, ex);
	throw ex;
}
}
		@AfterMethod
	    public void end(){
	        driver.quit();
	 
	    }
	    @AfterTest
	    public void endReport(){
	        extent.flush();
}
}

