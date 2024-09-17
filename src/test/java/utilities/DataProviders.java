package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	    // Specify the path of the Excel file
	    String path = ".\\testData\\OpenCart_LoginData.xlsx";

	    // Create an instance of ExcelUtility to read data from the Excel file
	    ExcelUtility xlutil = new ExcelUtility(path);

	    // Get the total number of rows and columns in the specified sheet
	    int totalRows = xlutil.getRowCount("Sheet1");
	    int totalCols = xlutil.getCellCount("Sheet1", 1);
	    // Create a 2D array to store the data from the Excel sheet
	    String loginData[][] = new String[totalRows][totalCols];

	    // Loop through each row and column, and populate the 2D array with data
	    for (int i = 1; i <= totalRows; i++) {
	        for (int j = 0; j < totalCols; j++) {
	            loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j); // Fetch data from Excel
	        }
	    }

	    // Return the 2D array to be used as the data source for the test
	    return loginData;
	}

}
