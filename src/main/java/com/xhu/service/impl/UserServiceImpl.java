package com.xhu.service.impl;

import com.xhu.enity.Accont;
import com.xhu.enity.User;
import com.xhu.mapper.UserMapper;
import com.xhu.service.IUserService;
import com.xhu.service.impl.ex.AccountNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void Login(Accont accont) {
        String uid=accont.getUid();
        String password=accont.getPassword();
        Accont localAccount=mapper.findByUid(uid);
        if(localAccount==null||!password.equals(localAccount.getPassword())){
            throw new AccountNotMatchException("账户或密码错误");
        }

    }

    @Override
    public User getUsername(String uid) {
        return mapper.findUserByUid(uid);
    }
}
