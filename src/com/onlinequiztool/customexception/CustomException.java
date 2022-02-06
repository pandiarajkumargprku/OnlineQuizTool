package com.onlinequiztool.customexception;

public class CustomException extends Exception {

	public CustomException(String message) {
		super(message);
	}
	
	public static class  AccessFailedException extends CustomException {
	    
		public AccessFailedException(String message) {
			super(message);
		}
	}
	
	public static class connectionException extends CustomException {

		public connectionException(String message) {
			super(message);
		}
		
	}
	
	public static class mailIdNotFoundException extends CustomException {

		public mailIdNotFoundException(String message) {
			super(message);
		}
	}
}
