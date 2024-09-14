package Utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Data Provider-1 for OpenCart Application login page
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException
	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrow = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		String Data[][] = new String[totalrow][totalcols];
		
		for(int r=1; r<=totalrow; r++)
		{
			for (int c=0; c<totalcols; c++)
			{
				Data[r-1][c] = xlutil.getCellData("Sheet1", r, c);
			}
		}
		return Data;
	}
}
