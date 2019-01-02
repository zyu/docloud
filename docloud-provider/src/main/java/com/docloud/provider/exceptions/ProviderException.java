package com.docloud.provider.exceptions;

public class ProviderException extends RuntimeException {

	public ProviderException() {
		super();
	}

	public ProviderException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProviderException(String message) {
		super(message);
	}

	public ProviderException(Throwable cause) {
		super(cause);
	}
}
