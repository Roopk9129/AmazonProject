package Amazon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import GenericUtilities.ExcelInputAndOutput;
import Pages.HomePage;

public class ProductSerchandtransfertoexcelsheettest extends BaseClass {
	@Test(dataProvider = "datap")
	
	public void productSerchandtransfertoexcelsheettest(String Valuu) throws Throwable {
		// objectCreation
		
		HomePage HP = new HomePage(driver);
		System.out.println(Valuu);
		HP.ProductSearchBar(Valuu);
		
		int CCount=1;
		//finding Elements
		List<WebElement> TT = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		ExcelInputAndOutput EXIO = new ExcelInputAndOutput();
		
		int count = 0;
		for (WebElement Tit : TT) {
			String txtt = Tit.getText();

			EXIO.excelInputWithIteration(TT, "E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\Outp.xlsx", "Sheet1",
					count, CCount, txtt);
			count++;
			CCount++;
		}
		

//		int count = 0;
//		int colcount = 0;
//		for (WebElement title : TT) {
//			
//			String txt = title.getText();
//			System.out.println(txt);
//
//			FileInputStream fiso = new FileInputStream("E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\05-06\\out.xlsx");
//			XSSFWorkbook xsf = new XSSFWorkbook(fiso);
//
//			XSSFSheet sheet = xsf.getSheet("Sheet1");
//			XSSFCell CreateCell = sheet.createRow(count).createCell(colcount);
//			count++;
//			CreateCell.setCellValue(txt);
//			FileOutputStream fisoo = new FileOutputStream(
//					"E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\05-06\\out.xlsx");
//			xsf.write(fisoo);
//
//		}colcount++;

	}

	ExcelInputAndOutput EIO = new ExcelInputAndOutput();

	@DataProvider
	public Object[][] datap() throws EncryptedDocumentException, IOException {
		Object[][] val = EIO.excelmultipledatapull("E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\05-06\\in.xlsx",
				"Sheet1", 0);
		return val;
	}

}
