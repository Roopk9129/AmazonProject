package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement ProductSearchBar;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement ProductSearchBtn;

	

	public WebElement getProductSearchBar() {
		return ProductSearchBar;
	}

	public WebElement getProductSearchBtn() {
		return ProductSearchBtn;
	}

	

	public String ProductSearchBar(String PN) {
		getProductSearchBar().sendKeys(PN,Keys.ENTER);
		return PN;
	}

	public void ProductSearchBtn() {
		getProductSearchBtn().click();
	}

	
}
