package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
	private WebElement ProductTitleInCart;

	public WebElement getProductTitleInCart() {
		return ProductTitleInCart;
	}

	public String ProductTitleInCart() {
		String PText = getProductTitleInCart().getText();
		return PText;
	}
}
