package utilities;


import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders{
	//DataProvider 1
	
		@DataProvider(name="FormData")
		public static String [][] getData() throws IOException
		{
			String path=".\\testData\\ReadyToTransform.xlsx";//taking xl file from testData
			
			ExcelUtils xlutil=new ExcelUtils();//creating an object for XLUtility
			
			int totalrows=ExcelUtils.getRowCount(path,"Sheet1");	
			int totalcols=ExcelUtils.getCellCount(path,"Sheet1",1);
					
			String homePageData[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int j=0;j<totalcols;j++)  //0    i is rows j is col
				{
					homePageData[i-1][j]= ExcelUtils.getCellData(path,"Sheet1",i, j);  //1,0
				}
				
			}
		return homePageData;//returning two dimension array
					
		}
}
