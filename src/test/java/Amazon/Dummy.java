package Amazon;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericUtilities.ExcelData;

public class Dummy {
	@Test
	public void dummy() throws IOException {
		ExcelData ED = new ExcelData();
		ED.excelDataInput("E:\\sam.xlsx", "Sheet1", 0, 0, "hello");
	}

}
