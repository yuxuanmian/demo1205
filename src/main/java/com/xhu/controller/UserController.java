package com.xhu.controller;

import com.xhu.enity.Accont;
import com.xhu.service.IUserService;
import com.xhu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController {

    private final IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public JsonResult<Accont> login(Accont ac) {
        service.Login(ac);
        JsonResult<Accont> result = new JsonResult<>();
        result.setData(ac);
        return result;
    }
}
