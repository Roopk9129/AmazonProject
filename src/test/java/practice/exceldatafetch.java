package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldatafetch {
	public static void main(String[] args) throws IOException {
		FileInputStream FIS = new FileInputStream("E:\\Selenium\\Eclipsse\\Inputs\\ExcelInput\\06-06\\demoqa.xlsx");
		XSSFWorkbook XSFW = new XSSFWorkbook(FIS);
		XSSFSheet sheet = XSFW.getSheet("Sheet1");
		int LRowNum = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int LCellNum = row.getLastCellNum();
		for(int r=0;r<LRowNum; r++) {
			XSSFRow Crow = sheet.getRow(r);
			for(int c=0;c<LCellNum;c++) {
				if(Crow.getCell(c).getCellType()==CellType.NUMERIC) {
					System.out.println(Crow.getCell(c).getNumericCellValue());
					
				}else {
					System.out.println(Crow.getCell(c).getStringCellValue());
				}
								
			}
			
		}XSFW.close();

	}

}