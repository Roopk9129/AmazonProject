package Amazon;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import Pages.HomePage;
import Pages.ProductResultsPage;

public class SponserdProducts extends BaseClass{
	@Test
	public void sponserdProducts() {
		HomePage HP= new HomePage(driver);
		ProductResultsPage PRP = new ProductResultsPage(driver);
		
		HP.ProductSearchBar("samsung");
		
	}

}
