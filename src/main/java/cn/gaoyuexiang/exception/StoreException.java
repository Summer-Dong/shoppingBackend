package cn.gaoyuexiang.exception;

public class StoreException extends RuntimeException {
	private static final long serialVersionUID = -3729145228666582077L;

	public StoreException() {
		super();
	}

	public StoreException(String message) {
		super(message);
	}

	public StoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public StoreException(Throwable cause) {
		super(cause);
	}

	protected StoreException(String message, Throwable cause,
	                         boolean enableSuppression,
	                         boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
