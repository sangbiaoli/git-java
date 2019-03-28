package com.sangbill.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super("应用异常");
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
		// this.cause = cause;
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		// this.cause = cause;
	}

}
