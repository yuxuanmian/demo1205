package com.xhu.controller;


import com.xhu.util.JsonResult;
import com.xhu.service.impl.ex.AccountNotMatchException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    protected final int OK = 200;

    @ExceptionHandler
    public JsonResult<Void> exceptionHandler(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof AccountNotMatchException){
            result.setState(5000);
        }
        return result;
    }
}
