package GenericUtilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReUsableMethods {

	public ReUsableMethods(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void windowHandlesWithIteratorMethod(WebDriver driver, String WindowTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> WI = window.iterator();
		while (WI.hasNext()) {
			String hand = WI.next();
			driver.switchTo().window(hand);
			String Title = driver.getTitle();
			if (Title.equals(WindowTitle)) {
				break;
			}
		}
	}
	public void windowHandlesWithForEach(WebDriver driver, String WinTitle) {
		Set<String> Win1 = driver.getWindowHandles();
		for (String ele : Win1) {
			driver.switchTo().window(ele);
			String Title = driver.getTitle();
			if (Title.contains(WinTitle)) {
				break;

			}
		}

	}

}
