package com.xhu.service.impl.ex;

public class AccountNotMatchException extends ServiceException{
    public AccountNotMatchException() {
        super();
    }

    public AccountNotMatchException(String message) {
        super(message);
    }

    public AccountNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotMatchException(Throwable cause) {
        super(cause);
    }

    protected AccountNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
