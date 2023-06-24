package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductResultsPage {
	public ProductResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//img[@class='s-image'])[1]")
	private WebElement Product;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement ProductTitle;

	@FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private List<WebElement> ListofTitles;

	public List<WebElement> getListofTitles() {
		return ListofTitles;
	}

	public WebElement getProduct() {
		return Product;
	}

	public WebElement getProductTitle() {
		return ProductTitle;
	}

	public void Product() {
		getProduct().click();
	}

	public String ProductTitle() {
		String PT = getProductTitle().getText();
		return PT;
	}

}
