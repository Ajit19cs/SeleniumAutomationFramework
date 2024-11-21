package com.cs.constants;

import java.util.Objects;

public final class FrameWorkConstatns {
	
    private FrameWorkConstatns() {}
    private static final String RESOURCEPATH=System.getProperty("user.dir")+"\\src\\test\\resources";
	//private static final String CHROMEDRIVERPATH=RESOURCEPATH+"\\executables\\chromedriver.exe";
	private static final String CONFIGFILEPATH=RESOURCEPATH+"\\properties\\ConfigProperties.properties";
	private static final String EXCELTESTDATAPATH=RESOURCEPATH+"\\properties\\testData.xlsx";
	private static final String EXCELTESTCASEPATH=RESOURCEPATH+"\\excel\\testcaseData.xlsx";
	private static final String EXTENTREPORTCONFIG=RESOURCEPATH+"\\properties\\extentReportFormat.json";
	private static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"\\extent-output\\";
	private static String extentFinalPath;
	
	private static final long EXPLICITEWAIT=10000;
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

//	public static String getDriverpath() {
//		return CHROMEDRIVERPATH;
//	}

	public static String getExceltestcasepath() {
		return EXCELTESTCASEPATH;
	}

	public static String getExtentreportconfig() {
		return EXTENTREPORTCONFIG;
	}

	public static long getExplicitewait() {
		return EXPLICITEWAIT;
	}

	public static String getExceltestdatapath() {
		return EXCELTESTDATAPATH;
	}

	public static String getExtentreportpath() {
		 if(Objects.isNull(extentFinalPath))
		 { 
			 extentFinalPath=EXTENTREPORTPATH+System.currentTimeMillis()+"\\index.html";
		 }
		
	  return extentFinalPath;
	}
	

}
