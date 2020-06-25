package CommonLibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData
{
	public String fetchDataFromProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("src/test/resources/CommonData.properties");
		Properties Pobj = new Properties();
		Pobj.load(file);
		String value = Pobj.getProperty(key);
		return value;
	}
	public String FetchDataFromExcel(String sheetName,int rowNum,int cellNum) throws IOException
	{
		FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;
	}
	public String AddDataToExcel(String sheetName,int rowNum,int cellNum,String value) throws IOException
	{
		FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream("TestData.xlsx");
		book.write(out);
		out.flush();
		System.out.println(value);
		return value;
	}
}
