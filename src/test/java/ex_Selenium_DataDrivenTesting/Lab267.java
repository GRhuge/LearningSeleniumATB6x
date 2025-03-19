package ex_Selenium_DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab267 {

	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = new FileInputStream("E:\\ABTB6x\\LearningSeleniumATB6x\\src\\test\\java\\ex_Selenium_DataDrivenTesting\\CTD.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if(cell.getCellType() == CellType.NUMERIC) {
					System.out.println(cell.getNumericCellValue());
				}
				if(cell.getCellType() == CellType.STRING) {
					System.out.println(cell.getStringCellValue());
				}
			}
		}
	}
}