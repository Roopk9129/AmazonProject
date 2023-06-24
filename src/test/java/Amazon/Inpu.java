package Amazon;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.*;

public class Inpu {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\New Microsoft Excel Worksheet.xlsx");
		FileOutputStream fos = new FileOutputStream("E:\\New Microsoft Excel Worksheet.xlsx");
		Workbook WB = WorkbookFactory.create(fis);
		WB.write(fos);
		Cell value = WB.createSheet("Sheet11").createRow(0).createCell(0);
		value.setCellValue("hey");
		

	}

}
