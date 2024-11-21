package com.cs.exceptions;

import com.cs.driver.Driver;

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {

	public FrameworkException(String message) {
	        super(message);
	        Driver.quitDriver();
	        
       }

	public FrameworkException(String message, Throwable cause) {
        super(message,cause);
        Driver.quitDriver();
       
   }
	

}
