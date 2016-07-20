package cn.gaoyuexiang.exception;

public class NoSuchItemException extends StoreException{
	public NoSuchItemException() {
		super();
	}

	public NoSuchItemException(String message) {
		super(message);
	}

	public NoSuchItemException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchItemException(Throwable cause) {
		super(cause);
	}

	protected NoSuchItemException(String message, Throwable cause,
	                              boolean enableSuppression,
	                              boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
