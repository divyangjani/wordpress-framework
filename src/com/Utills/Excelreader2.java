package com.Utills;

import org.testng.annotations.DataProvider;

public class Excelreader2 {
	
	
	public static String path="C:\\Users\\Abhi Jani\\Desktop\\Wordpress.xlsx";
	public static String sheetname="Sheet1";
		
		
//public static void main(String[] args) throws Exception {
	
//	getdata();
//}

@DataProvider(name="createpost")
public static Object[][] createpost() throws Exception
{
	Object postdata[][]=getdata();
	
	return postdata;
	
}
	public static Object[][] getdata() throws Exception
	{
		ExcelUtills utill=new ExcelUtills(path, sheetname);
		
		int rows=utill.total_rows();
		int columns=utill.total_col();
		
		Object data[][]=new Object[rows-1][columns];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				System.out.println(utill.celldata(i, j));
				
				data[i-1][j]=utill.celldata(i, j);
				
			}
		}
		return data;
	}

}
