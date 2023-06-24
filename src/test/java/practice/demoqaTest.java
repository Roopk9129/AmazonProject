package practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelInputAndOutput;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqaTest {

	@Test(dataProvider = "data")
	public void m1(String FirstName, String Lastname, String Email, String Gender, String MobNum) {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Email);
		if (Gender.equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		} else if (Gender.equalsIgnoreCase("female")) {
			driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
		} else {
			driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
		}
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(MobNum);
		driver.findElement(By.xpath("//button[@id='submit']")).click();

	}

	ExcelInputAndOutput EIAO = new ExcelInputAndOutput();

	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException {
		Object[][] vaal = EIAO.excelmultipledatapull("E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\06-06\\demoqa.xlsx", "Sheet2",
				0);
		return vaal;
	}
	
	
}