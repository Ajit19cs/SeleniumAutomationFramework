package com.cs.exceptions;

@SuppressWarnings("serial")
public class PropertyFileValueException extends FrameworkException {

	public PropertyFileValueException(String message) {
	        super(message);
       }

	public PropertyFileValueException(String message, Throwable cause) {
        super(message,cause);
   }
	

}
