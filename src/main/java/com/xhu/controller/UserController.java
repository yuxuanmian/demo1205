package com.xhu.controller;

import com.xhu.enity.Accont;
import com.xhu.enity.User;
import com.xhu.service.IUserService;
import com.xhu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController extends BaseController {

    private final IUserService service;

    private final HttpSession session;

    @Autowired
    public UserController(IUserService service,HttpSession session) {
        this.service = service;
        this.session=session;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<Accont> login(Accont ac) {
        service.Login(ac);
        JsonResult<Accont> result = new JsonResult<>(OK);
        result.setData(ac);

        session.setAttribute("uid", ac.getUid());

        return result;
    }

    @RequestMapping("/getUsername")
    public JsonResult<User> getUsername(){
        String uid=getUidInSession(session);
        User userRes = service.getUsername(uid);

        JsonResult<User> result = new JsonResult<>(OK);
        result.setData(userRes);

        return result;
    }
}
