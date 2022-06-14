package com.maomao.patterndesign.p1_proxy;

public class UserDaoImpl implements UserDao{
    private String userInfo;

    @Override
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
        System.out.println("插入信息：" + userInfo);
    }

    @Override
    public String getUserInfo() {
        System.out.println("获取信息：" + userInfo);
        return userInfo;
    }
}
