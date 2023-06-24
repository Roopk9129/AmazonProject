package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelInputAndOutput {

	public String excelInput(String ExcelPath, String SheetName, int RowNum, int ColumnNum) throws IOException {
		FileInputStream FIS = new FileInputStream(ExcelPath);
		Workbook WB = WorkbookFactory.create(FIS);
		String Value = WB.getSheet(SheetName).getRow(RowNum).getCell(ColumnNum).getStringCellValue();
		return Value;

	}

	public int excelIteration(String ExcelPath, String SheetName, int RowNum, int ColumnNum)
			throws Throwable, IOException {
		FileInputStream FIS = new FileInputStream(ExcelPath);
		Workbook WB = WorkbookFactory.create(FIS);
		Sheet sheet = WB.getSheet(SheetName);
		int lastRow = sheet.getLastRowNum();
		return lastRow;
	}

	public Object[][] excelmultipledatapull(String ExcelPath, String SheetName, int RowNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fiss = new FileInputStream(ExcelPath);
		Workbook WB = WorkbookFactory.create(fiss);
		Sheet sheet = WB.getSheet(SheetName);
		int LastRow = sheet.getLastRowNum();
		Row row = sheet.getRow(RowNum);
		int LastCell = row.getLastCellNum();

		Object[][] obj = new Object[LastRow][LastCell];
		for (int r = 0; r < LastRow; r++) {
			for (int c = 0; c < LastCell; c++) {
				obj[r][c] = sheet.getRow(r).getCell(c).getStringCellValue();

			}

		}
		return obj;

	}
	public String excelInputWithIteration(List<WebElement> Ele, String FilePath, String SheetName, int RowNum,
			int CellNum, String value) throws IOException {
			FileInputStream FIS = new FileInputStream(FilePath);
			XSSFWorkbook XWB = new XSSFWorkbook(FIS);
			XSSFSheet sheet = XWB.getSheet(SheetName);
			XSSFRow row = sheet.createRow(RowNum);
			XSSFCell cell = row.createCell(CellNum);
			CellNum++;
			cell.setCellValue(value);

			FileOutputStream FOS = new FileOutputStream(FilePath);
			XWB.write(FOS);
			XWB.close();
			System.out.println(value);
		return value;
	}
}
