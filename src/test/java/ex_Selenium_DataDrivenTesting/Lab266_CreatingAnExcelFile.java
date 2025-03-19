package ex_Selenium_DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab266_CreatingAnExcelFile  {
	
	public static void main(String[] args) throws IOException {
		
		Map<String, Object> data = new TreeMap<>();
		data.put("1", new Object[] {"LoginId","Email","Password"});
		data.put("2", new Object[] {"1", "krsna@live.com", "123456"});
		data.put("3", new Object[] {"2", "ramsita@gmail.com", "123789"});
		
		
		Set<String> keyset = data.keySet();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Main");
		
		int rownum=0;
		
		for(String key: keyset) {
			Row r = sheet.createRow(rownum++);
			Object[] objectA = (Object[]) data.get(key);
			int cellnum = 0;
			for(Object o: objectA) {
				Cell cell = r.createCell(cellnum++);
				cell.setCellValue((String)o);
			}
		}
		
		FileOutputStream outputStream = new FileOutputStream(new String("E:\\ABTB6x\\LearningSeleniumATB6x\\src\\test\\java\\ex_Selenium_DataDrivenTesting\\CTD.xlsx"));
		workbook.write(outputStream);
		outputStream.close();
	}
}
