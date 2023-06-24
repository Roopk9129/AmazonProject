import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExccelIandO {

	public Object[][] ExcelIn() throws Throwable {
		FileInputStream fis = new FileInputStream("E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\06-06\\demoqa.xlsx");
		Workbook WB = WorkbookFactory.create(fis);
		Sheet sh = WB.getSheet("Sheet1");
		int LR = sh.getLastRowNum();
		Row row = sh.getRow(0);
		int LC = row.getLastCellNum();
		Object[][] objx = new Object[LR][LC];
		for (int r = 0; r < LR; r++) {
			for (int c = 0; c < LC; c++) {
				objx[r][c] = sh.getRow(r).getCell(c).getStringCellValue();

			}

		}
		return objx;
	}

}
