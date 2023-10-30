package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		//Step1:open the doc in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		
		//Step2: create work book
		Workbook book=WorkbookFactory.create(fis);
		
		//Step3: navigate to required sheet
		Sheet sh = book.getSheet("Contact");
		
		//Step4: navigate to required row
		Row row = sh.getRow(7);
		
		//Step5:navigate to required cell
		Cell cell = row.getCell(1);
		
		//Step6: capture the value inside cell and print
		String value = cell.getStringCellValue();
		System.out.println(value);

	}

}
