package Amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelData;
import GenericUtilities.ReUsableMethods;
import Pages.HomePage;
import Pages.ProductResultsPage;
import Pages.ShoppingCartPage;
import Pages.productPage;

public class ProductSearchAddToCartAndValidation extends BaseClass {

	@Test
	public void Validation() throws Exception {
		// object Creation
		HomePage HM = new HomePage(driver);
		productPage PP = new productPage(driver);
		ProductResultsPage PRP = new ProductResultsPage(driver);
		ExcelData ED = new ExcelData();
		ReUsableMethods RUM = new ReUsableMethods(driver);
		ShoppingCartPage SCP = new ShoppingCartPage(driver);

		// logics
		String ExD = ED.ExcelDataExtraction("Sheet1", 0, 0);
		HM.ProductSearchBar(ExD);
		HM.ProductSearchBtn();
		PRP.Product();
		String TT = PRP.ProductTitle();
		RUM.windowHandlesWithIteratorMethod(driver, TT);
		PP.AddToCartBtn();
		PP.CartBtn();
		String ProductText = SCP.ProductTitleInCart();
		Assert.assertEquals(TT, ProductText);
		System.out.println("Title Validation pass");

	}

}
