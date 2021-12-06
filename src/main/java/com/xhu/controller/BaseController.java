package com.xhu.controller;


import com.xhu.util.JsonResult;
import com.xhu.service.impl.ex.AccountNotMatchException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    protected final int OK = 200;

    @ExceptionHandler
    protected JsonResult<Void> exceptionHandler(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof AccountNotMatchException){
            result.setState(5000);
            e.printStackTrace();
        }
        return result;
    }

    protected final String getUidInSession(HttpSession session){
        return session.getAttribute("uid").toString();
    }


}
