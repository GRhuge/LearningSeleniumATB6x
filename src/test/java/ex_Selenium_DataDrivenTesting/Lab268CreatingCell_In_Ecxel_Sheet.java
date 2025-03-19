package ex_Selenium_DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab268CreatingCell_In_Ecxel_Sheet {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Main");
		
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellValue("krsna");
		
		FileOutputStream outputStream = new FileOutputStream(new String("SELLSPECIFIC.xlsx"));
		workbook.write(outputStream);
		outputStream.close();
	}
}