package practice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AmazonDataExtractor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open Amazon website and search for a product
            driver.get("https://www.amazon.com");

            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            searchInput.sendKeys("your search query");

            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            // Extract product titles and prices
            List<WebElement> productTitles = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
            List<WebElement> productPrices = driver.findElements(By.cssSelector("span.a-price-whole"));

            // Create a new Workbook and Sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Product Details");

            // Add headers to the sheet
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Product Title");
            headerRow.createCell(1).setCellValue("Price");

            // Iterate over the product titles and prices and add them to the sheet
            for (int i = 0; i < productTitles.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(productTitles.get(i).getText());
                row.createCell(1).setCellValue(productPrices.get(i).getText());
            }

            // Save data to an Excel file
            try (FileOutputStream outputStream = new FileOutputStream("product_details.xlsx")) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}