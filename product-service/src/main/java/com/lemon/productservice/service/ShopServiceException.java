package com.lemon.productservice.service;

public class ShopServiceException extends RuntimeException {

	private static final long serialVersionUID = 2793502123203912031L;

	public ShopServiceException() {
		super();
	}

	public ShopServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShopServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShopServiceException(String message) {
		super(message);
	}

	public ShopServiceException(Throwable cause) {
		super(cause);
	}
}
