package com.qa.utility;

import java.util.ArrayList;

public class TestUtil {
	
	static ExcelReader reader;
	
	public static ArrayList<Object[]> getExcelData() {
		
		ArrayList<Object[]>loginTestData = new ArrayList<Object[]>();
		
		try {
			reader = new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\DemoTestData.xlsx");
			System.out.println("Excel File has been read sucessfully.....");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		for(int rowNum=2;rowNum<=reader.getRowCount("LoginTestData");rowNum++) {
			
			String firstName=reader.getCellData("LoginTestData", "FirstName", rowNum);
			String lastName=reader.getCellData("LoginTestData", "LastName", rowNum);
			String emailId=reader.getCellData("LoginTestData", "EmailId", rowNum);
			String password=reader.getCellData("LoginTestData", "Password", rowNum);
			Object obj[] = {firstName,lastName,emailId,password};
			loginTestData.add(obj);
				
		}
		
		return loginTestData;
		
	}
	



}
