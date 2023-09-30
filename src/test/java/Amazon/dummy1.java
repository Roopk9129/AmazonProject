package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class dummy1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		WebElement usernametxtfld = driver.findElement(By.xpath("//input[@id='user-name']"));
		usernametxtfld.sendKeys("standard_user");
	}

}
