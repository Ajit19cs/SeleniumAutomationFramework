package com.cs.utils;

public final class  DynamicXpathUtils {
	
	private DynamicXpathUtils() {
		
	}
	
	public static String getDynamicXpath(String xpath,String textToReplace) {
		
		return String.format(xpath, textToReplace);
		
		
	}

}
