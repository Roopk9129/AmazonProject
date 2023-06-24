package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	public productPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddToCartBtn;

	@FindBy(xpath = "//form[@id='attach-view-cart-button-form']//input[@class='a-button-input' and @type='submit']")
	private WebElement CartBtn;

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement TitleOfTheProduct;

	@FindBy(xpath = "//span[@class='a-price aok-align-center']//span[@class='a-offscreen']")
	private WebElement PriceOfProduct;

	public WebElement getTitleOfTheProduct() {
		return TitleOfTheProduct;
	}

	public WebElement getPriceOfProduct() {
		return PriceOfProduct;
	}

	public WebElement getAddToCartBtn() {
		return AddToCartBtn;
	}

	public WebElement getCartBtn() {
		return CartBtn;
	}

	public void AddToCartBtn() {
		getAddToCartBtn().click();
	}

	public void CartBtn() {
		getCartBtn().click();
	}

	public String TitleOfTheProduct() {
		return getTitleOfTheProduct().getText();
	}

	public String PriceOfProduct() {
		return getPriceOfProduct().getText();
	}

}
