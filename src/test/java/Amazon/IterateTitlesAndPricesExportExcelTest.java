package Amazon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import GenericUtilities.ReUsableMethods;
import Pages.HomePage;

public class IterateTitlesAndPricesExportExcelTest extends BaseClass {
	// export to excel
//		public void excelOutputIte(int Row,int Cell,String Value) throws EncryptedDocumentException, IOException {
//			String FilePath="E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\New folder\\OutPut.xlsx";
//			FileInputStream FISO = new FileInputStream(FilePath);
//			XSSFWorkbook XWB = new XSSFWorkbook(FISO);	
//			 XSSFSheet sheet = XWB.getSheet("Sheet1");
//			 XSSFRow Crow = sheet.createRow(Row);
//			 XSSFCell CCell = Crow.createCell(Cell);
//			 CCell.setCellValue(Value);
//			 Cell++;
//			 FileOutputStream FOSO = new FileOutputStream(FilePath);
//			 XWB.write(FOSO);
//			 Row++;
//			 XWB.close();
//		}
	@Test
	public void iterateTitlesAndPricesExportExcelTest() throws Throwable {
		// Objects
		HomePage HP = new HomePage(driver);
		ReUsableMethods RUM = new ReUsableMethods(driver);

		// dataPullfromExcel
		FileInputStream fis = new FileInputStream(
				"E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\New folder\\Input.xlsx");
		Workbook WB = WorkbookFactory.create(fis);
		Sheet sh = WB.getSheet("Sheet1");
		for (Row rr : sh) {
			for (Cell cc : rr) {
				String InputValue = cc.toString();
				System.out.println(InputValue);
				HP.ProductSearchBar(InputValue);
				List<WebElement> ClicableProducts = driver
						.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
				int Ceell = 0;
				int RR = 0;
				for (WebElement ele : ClicableProducts) {
					ele.click();
					String ttt = ele.getText();
					String TitlWin = driver.getTitle();
					RUM.windowHandlesWithIteratorMethod(driver, ttt);
					String ProductTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
					String Stock = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-success']"))
							.getText();
					System.out.println(ProductTitle);
					System.out.println(Stock);
					String FilePath = "E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\07-6\\New folder\\OutPut.xlsx";
					FileInputStream FISO = new FileInputStream(FilePath);
					XSSFWorkbook XWB = new XSSFWorkbook(FISO);
					XSSFSheet sheet = XWB.getSheet("Sheet1");
					sheet.createRow(RR).createCell(Ceell).setCellValue(ProductTitle);
					FileOutputStream FOSO = new FileOutputStream(FilePath);
					XWB.write(FOSO);
					Ceell++;
					sheet.createRow(RR).createCell(Ceell).setCellValue(Stock);
					RR++;
					FileOutputStream FOSOo = new FileOutputStream(FilePath);
					XWB.write(FOSOo);
					driver.close();
					XWB.close();
					RUM.windowHandlesWithIteratorMethod(driver, TitlWin);
				}
				HP.getProductSearchBar().clear();
			}
		}
	}

}
