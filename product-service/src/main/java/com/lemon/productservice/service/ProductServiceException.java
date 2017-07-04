package com.lemon.productservice.service;

public class ProductServiceException extends RuntimeException {

	private static final long serialVersionUID = 2793502123203912031L;

	public ProductServiceException() {
		super();
	}

	public ProductServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductServiceException(String message) {
		super(message);
	}

	public ProductServiceException(Throwable cause) {
		super(cause);
	}
}
