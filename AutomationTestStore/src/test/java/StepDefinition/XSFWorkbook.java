package StepDefinition;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XSFWorkbook {

	@Test
	public void readdata() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\PC\\Downloads\\book.xlsx");
		Workbook workbook = new XSSFWorkbook(fi);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row2=sheet.createRow(2);
		Cell cell5=row2.createCell(0);
		cell5.setCellValue("Column5");
		
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell.getStringCellValue()+" ");
			}
			System.out.println(" ");
		}
		workbook.close();
		fi.close();
		

	}

}
