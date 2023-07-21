package GenericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	PropertyFile PF = new PropertyFile();

	@BeforeSuite
	public void BS() {
		System.out.println("BS Executed");
	}

//	@BeforeTest
//	public void BT() {
//		System.out.println("BT Executed");
//
//	}

//	@Parameters("browser")
	@BeforeTest
//	public void BC(String Browser) {
	public void BC() throws IOException {
		String Browser = PF.AmazonUrlFetch("browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		System.out.println("BC Executed");
	}

	@BeforeMethod
	public void BM() throws IOException {
		String URRL = PF.AmazonUrlFetch("url");
		driver.get(URRL);
		System.out.println("BM Executed");

	}

	@AfterSuite
	public void AS() {
		System.out.println("AS Executed");
	}

//	@AfterTest
//	public void AT() {
//		System.out.println("AT Executed");
//	}

	@AfterClass
	public void AC() {
		System.out.println("AC Executed");
	}

	@AfterMethod
	public void AM() {
		System.out.println("AM Executed");
	}

}
