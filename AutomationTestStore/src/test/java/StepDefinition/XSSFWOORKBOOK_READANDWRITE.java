package StepDefinition;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class XSSFWOORKBOOK_READANDWRITE {
	WebDriver driver;
	public static String data="";
	String baspath = "https://httpbin.org/";
	String endpoint = "post";
	
	@Test(enabled=false)
	public void xssfworkbook_reading() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		FileInputStream fis = null;
		try {
		fis=new FileInputStream("D:\\rohit\\Education\\Test.xlsx");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			String cellval=cell.getStringCellValue();
			driver.findElement(By.id("APjFqb")).sendKeys(cellval);
			
			driver.findElement(By.id("APjFqb")).clear();
			Thread.sleep(1000);
		}
		
		
	}
	@Test(enabled=true)
	public void xssfworkbook_writing() throws IOException, InterruptedException{
		FileOutputStream fos= null;
		try {
		 fos=new FileOutputStream("D:\\rohit\\Education\\Test1.xlsx");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("new sheet made");
		for(int i=0;i<10;i++) {
			XSSFRow row=sheet.createRow(i);
			XSSFCell cell=row.createCell(0);
			cell.setCellValue("new cell created at row "+i);
			
			Thread.sleep(1000);
			
		}
		workbook.write(fos);
	}
}