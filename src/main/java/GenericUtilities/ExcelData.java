package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public String ExcelDataExtraction(String SheetName, int row, int cell) throws Exception {
		FileInputStream fisx = new FileInputStream(
				"E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\19-04\\ProductNames.xlsx");

		Workbook WB = WorkbookFactory.create(fisx);
		
		Sheet sheet = WB.getSheet(SheetName);
		Row row1 = sheet.getRow(row);
		Cell cell1 = row1.getCell(cell);
		String ExcelValue = cell1.getStringCellValue();
		return ExcelValue;

	}

	public void excelDataInput(String path,String SheetName, int rowc, int cellc, String Message) throws IOException {
		Workbook XW = new HSSFWorkbook();
		Cell cell = XW.createSheet(SheetName).createRow(rowc).createCell(cellc);
		cell.setCellValue(Message);
		FileOutputStream fio = new FileOutputStream(path);
		Workbook wbf = WorkbookFactory.create(fio);
		wbf.write(fio);
		XW.close();
		
	}

}
