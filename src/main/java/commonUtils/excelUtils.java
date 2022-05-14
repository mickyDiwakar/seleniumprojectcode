package commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class excelUtils {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook=null;
	//public static File file;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static String filepath="C:\\selenium\\SeleniumBDDFramework\\testData\\";
	
	/*
	 * private excelUtils(){ //workbook=new XSSFWorkbook();
	 * 
	 * }
	 */

	/*
	 * public static excelUtils getexcelUtilsInstance() { return new excelUtils(); }
	 */
	public static Object getData(String fileName,String sheetName) throws FileNotFoundException {
		Object[][] data=null;
		String finalfilepath=filepath+fileName+".xlsx";
		fis=new FileInputStream(new File(finalfilepath));
		workbook=new XSSFWorkbook();
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		int cellcount =sheet.getRow(0).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		return data;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		excelUtils.getData("test","Datasheet");
		
		//excelUtils.getexcelUtilsInstance().getData("test","Datasheet");
		
	}
}
