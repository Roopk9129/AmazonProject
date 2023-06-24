package Amazon;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtilities.BaseClass;
import GenericUtilities.ReUsableMethods;
import Pages.HomePage;
import Pages.ProductResultsPage;
import Pages.ShoppingCartPage;
import Pages.productPage;

public class AddMultipleProductsToCartandValidateTest extends BaseClass {
	@Test
	public void addMultipleProductsToCartandValidateTest() {
		HomePage HP = new HomePage(driver);
		ProductResultsPage PRP = new ProductResultsPage(driver);
		ReUsableMethods RUM = new ReUsableMethods(driver);
		productPage PP = new productPage(driver);
		ShoppingCartPage SCP = new ShoppingCartPage(driver);
		SoftAssert SA = new SoftAssert();

		HP.getProductSearchBar().sendKeys("Dolls", Keys.ENTER);
		List<WebElement> Titles = PRP.getListofTitles();
		String parentW = driver.getTitle();
		for (WebElement tit : Titles) {
			String text = tit.getText();

			tit.click();
			RUM.windowHandlesWithForEach(driver, text);

			PP.AddToCartBtn();
			String Ctitle = SCP.ProductTitleInCart();
			SA.assertEquals(text, Ctitle);
			driver.close();
			RUM.windowHandlesWithForEach(driver, parentW);

		}
		SA.assertAll();

	}

}
