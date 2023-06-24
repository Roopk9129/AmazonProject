package Amazon;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelData;
import GenericUtilities.ReUsableMethods;
import Pages.HomePage;
import Pages.ProductResultsPage;
import Pages.productPage;

public class ProductSearchAndAddToCat extends BaseClass {
	@Test
	public void AddToCart() throws Exception {

		// ObjecCreation
		ExcelData ED = new ExcelData();
		HomePage HP = new HomePage(driver);
		ProductResultsPage PRP = new ProductResultsPage(driver);
		ReUsableMethods RUM = new ReUsableMethods(driver);
		productPage PP = new productPage(driver);
		// Test
		String EData = ED.ExcelDataExtraction("Sheet1", 0, 0);
		HP.ProductSearchBar(EData);
		HP.ProductSearchBtn();
		PRP.Product();
		String pt = PRP.ProductTitle();
		RUM.windowHandlesWithForEach(driver, pt);
//		RUM.windowHandlesWithIteratorMethod(driver,pt);
		PP.AddToCartBtn();

	}

}
