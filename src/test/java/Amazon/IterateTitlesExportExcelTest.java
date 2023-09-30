package Amazon;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelInputAndOutput;
import GenericUtilities.ReUsableMethods;
import Pages.HomePage;
import Pages.productPage;

public class IterateTitlesExportExcelTest extends BaseClass {
	@Test(dataProvider = "getData")
	public void iterateTitlesPricesExportExcelTest(String Value) throws IOException {
		// Object Creation
		HomePage HP = new HomePage(driver);
		ReUsableMethods RUM = new ReUsableMethods(driver);
		productPage PP = new productPage(driver);
		ExcelInputAndOutput EIOP = new ExcelInputAndOutput();

		// BL
		int RCount=0;
		HP.ProductSearchBar(Value);
		List<WebElement> Title = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		
		for(WebElement ele:Title) {
			String WindowTitle = ele.getText();
			ele.click();
			RUM.windowHandlesWithIteratorMethod(driver, WindowTitle);
			String TitleoftheProduct = PP.TitleOfTheProduct();
//			String PriceoftheProduct = PP.PriceOfProduct();
//			String Details=TitleoftheProduct+PriceoftheProduct;
			System.out.println(TitleoftheProduct);
			EIOP.excelInputWithIteration(Title, "E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\New folder\\OutPut.xlsx", "Sheet1", RCount, 0, TitleoftheProduct);
			RCount++;
			driver.close();
			RUM.windowHandlesWithIteratorMethod(driver, Value);

			
			
			
		
			
		}

	}

	ExcelInputAndOutput EIO = new ExcelInputAndOutput();

	@DataProvider
	public Object[][] getData() throws Throwable, IOException {
		Object[][] val = EIO.excelmultipledatapull(
				"E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\New folder\\Input.xlsx", "Sheet1", 0);
		return val;
	}

}
