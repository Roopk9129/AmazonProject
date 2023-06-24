package Amazon;

	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileOutputStream;
	import java.io.IOException;

	public class ExcelWriterExample {
	    public static void main(String[] args) {
	        // Create a new workbook
	        Workbook workbook = new XSSFWorkbook();
	        
	        // Create a new sheet
	        Sheet sheet = workbook.createSheet("Sheet1");
	        
	        // Create some data to write
	        Object[][] data = {
	            {"Name", "Age", "City"},
	            {"John Doe", 25, "New York"},
	            {"Jane Smith", 30, "London"},
	            {"Bob Johnson", 45, "Paris"}
	        };
	        
	        // Write the data to the sheet
	        int rowNum = 0;
	        for (Object[] rowData : data) {
	            Row row = sheet.createRow(rowNum++);
	            int colNum = 0;
	            for (Object cellData : rowData) {
	                Cell cell = row.createCell(colNum++);
	                if (cellData instanceof String) {
	                    cell.setCellValue((String) cellData);
	                } else if (cellData instanceof Integer) {
	                    cell.setCellValue((Integer) cellData);
	                }
	            }
	        }
	        
	        // Save the workbook to a file
	        try (FileOutputStream outputStream = new FileOutputStream("‪E:\\sample.xlsx")) {
	            workbook.write(outputStream);
	            System.out.println("Excel file created successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


