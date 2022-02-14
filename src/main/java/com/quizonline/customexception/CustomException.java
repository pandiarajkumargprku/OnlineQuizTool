package com.quizonline.customexception;

public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
	}
	
	public static class  AccessFailedException extends CustomException {
	    
		public AccessFailedException(String message) {
			super(message);
		}
	}
	
	public static class ConnectionException extends CustomException {

		public ConnectionException(String message) {
			super(message);
		}
	}
	
	public static class MailIdNotFoundException extends CustomException {

		public MailIdNotFoundException(String message) {
			super(message);
		}
	}

	public static class NumberFormatException extends CustomException {

		public NumberFormatException(String message) {
			super(message);
		}
	}
	
	public static class PasswordNotFoundException extends CustomException {

		public PasswordNotFoundException(String message) {
			super(message);
		}
	}
}
