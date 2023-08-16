package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SponsoredProducts {
@Test
    public void  sponsoredProducts(){
        // Initialize the WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open the Amazon website
        driver.get("https://www.amazon.com/");

        // Find the element that contains all the sponsored products
        WebElement sponsoredProductsElement = driver.findElement(By.id("sponsoredProducts"));

        // Get all the children of the sponsoredProductsElement
        List<WebElement> sponsoredProducts = sponsoredProductsElement.findElements(By.tagName("li"));

        // Loop through all the sponsored products and print their titles
        for (WebElement sponsoredProduct : sponsoredProducts) {
            System.out.println(sponsoredProduct.findElement(By.className("a-link-normal")).getText());
        }

        // Close the WebDriver
        driver.close();
    }
}

