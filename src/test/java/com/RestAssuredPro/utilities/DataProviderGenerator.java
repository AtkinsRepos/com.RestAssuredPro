package com.RestAssuredPro.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderGenerator 
{

	@DataProvider(name = "EmployeeData")
	public static String[][] getEmployeeData() throws IOException {
		String path = System.getProperty("user.dir") + "//src//test//resource//TestData//empdata.xlsx";

		int rownum = XLUtils.getRowCount(path, "NewEmployee");
		int colcount = XLUtils.getCellCount(path, "NewEmployee", 1);
		
		String EmployeeData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				EmployeeData[i - 1][j] = XLUtils.getCellData(path, "NewEmployee", i, j);
		}
	}

		return EmployeeData;
		
	}
	
	@DataProvider(name = "INvalidSignUpData2")
	public static Object[][] getSignUpData2() throws IOException {
		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";

		int rownum = XLUtils.getRowCount(path, "INvalidSignUp");
		int colcount = XLUtils.getCellCount(path, "INvalidSignUp", 1);

		String signUpData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				signUpData[i - 1][j] = XLUtils.getCellData(path, "INvalidSignUp", i, j);
			}
		}

		return signUpData ;

	}
//	@DataProvider(name = "INvalidSignUpData3")
//	public static String[][] getSignUpData3() throws IOException {
//		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//NwComp_3.xlsx";
//
//		int rownum = XLUtils.getRowCount(path, "INvalidSignUp2");
//		int colcount = XLUtils.getCellCount(path, "INvalidSignUp2", 1);
//
//		String signUpData[][] = new String[rownum][colcount];
//
//		for (int i = 1; i <= rownum; i++) {
//			for (int j = 0; j < colcount; j++) {
//				signUpData[i - 1][j] = XLUtils.getCellData(path, "INvalidSignUp2", i, j);
//			}
//		}
//
//		return signUpData;
//
//	}
	
}
