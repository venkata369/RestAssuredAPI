

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtils(String excelpath, String sheetName) {
		try {
		 workbook = new XSSFWorkbook(excelpath);
		 sheet = workbook.getSheet("Sheet1");
		
	}catch (Exception exp) {
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
	}		
	}
	//get data from excel
		public static void getCellData(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
	}
	
		public void getRowCount() {
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of rows:"+rowcount);
	}

}
