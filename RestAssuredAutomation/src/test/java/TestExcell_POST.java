

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.XLUtils;

public class TestExcell_POST{
	
	@DataProvider(name = "DataForPost")	
	public Object[][] dataForPost(){

		Object[][] data = new Object[2][3];
		String excelpath = "./excel/api.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath, sheetName);
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
		return data;
	}
	
	
	
}

	
	/*String[][] getData() throws IOException{
		XLUtils XLUtils = new XLUtils();
		String path= System.getProperty("user.dir")+"/excel/api.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		//Store two dimensional Array

		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.println("Data is:"+XLUtils.getCellData(path, "Sheet1", i, j));
			}

		}
		return logindata;		
//	}*/
	
