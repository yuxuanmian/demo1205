package com.xhu.service;

import com.xhu.enity.Accont;
import com.xhu.enity.User;

public interface IUserService {
    void Login(Accont accont);

    User getUsername(String uid);
}
