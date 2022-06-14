package com.maomao.patterndesign.p1_proxy;

import java.util.Date;

public class LogStaticProxy implements UserDao{
    UserDao userDao;
    public LogStaticProxy(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void setUserInfo(String userInfo) {
        before();
        this.userDao.setUserInfo(userInfo);
        after();
    }

    @Override
    public String getUserInfo() {
        before();
        String rst = this.userDao.getUserInfo();
        after();
        return rst;
    }
    
    private void before(){
        System.out.println("log before" + (new Date().toString()));
    }

    private void after(){
        System.out.println("log after" + (new Date().toString()));
    }
}
