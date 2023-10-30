package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws Throwable {
		//step1:create object of a workbook interface
		Workbook book=new XSSFWorkbook();
		
		//step2: create a sheet in the workbook
		Sheet sheet = book.createSheet("exceldata");
		
		//step3:create new row
		Row row = sheet.createRow(0);
		
		//step4:create first cell
		Cell cell = row.createCell(0);
		
		//step5: set the values
		cell.setCellValue("TC_ID");
		
		//step6:create second cell
		Cell cell1 = row.createCell(1);
				
		//step7: set the values
		cell1.setCellValue("TC_Name");
		
		//step8: create third cell
		Cell cell2=row.createCell(2);
		//step9:set the values
		cell2.setCellValue("LastName");
		
		//step10:create second row
		Row row1 = sheet.createRow(1);
		
		//step11: create cells in the second row and set the values
		Cell cell3 = row1.createCell(0);
		cell3.setCellValue("TC_01");
		Cell cell4 = row1.createCell(1);
		cell4.setCellValue("CreateContact");
		Cell cell5 = row1.createCell(2);
		cell5.setCellValue("Jaisri");
		
		//step6: create object of FileOutputStream 
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\outputfile.xlsx");
		book.write(fos);
		
	}

}
