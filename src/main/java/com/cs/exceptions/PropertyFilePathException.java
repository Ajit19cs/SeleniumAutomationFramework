package com.cs.exceptions;

@SuppressWarnings("serial")
public class PropertyFilePathException extends FrameworkException {

	public PropertyFilePathException(String message) {
	        super(message);
       }

	public PropertyFilePathException(String message, Throwable cause) {
        super(message,cause);
   }
	

}
