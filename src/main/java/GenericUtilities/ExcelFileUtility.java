package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel
 * @author PRIYA C
 */
public class ExcelFileUtility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	
	public String readDatafromEcxel(String sheetName,int rowNum,int cellNum) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
			
	}
	/**
	 * This method will read multiple data from excel sheet at a time
	 * used for data provider
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	
	public Object[][] readMultipleData(String sheetName) throws IOException{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				}
		}
		return data;
	}

}
