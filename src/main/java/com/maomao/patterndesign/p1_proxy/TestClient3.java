package com.maomao.patterndesign.p1_proxy;

import org.springframework.cglib.proxy.Enhancer;

public class TestClient3 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserDaoImpl.class);
        LogMethodInterceptor interceptor = new LogMethodInterceptor();
        enhancer.setCallback(interceptor);
        UserDao userDao = (UserDao) enhancer.create();

        userDao.setUserInfo("我是cglib");

        System.out.println(userDao.getUserInfo());
        // log beforeTue Jun 14 21:13:15 CST 2022
        // 插入信息：我是cglib
        // log afterTue Jun 14 21:13:15 CST 2022
        // log beforeTue Jun 14 21:13:15 CST 2022
        // 获取信息：我是cglib
        // log afterTue Jun 14 21:13:15 CST 2022
        // 我是cglib
    }
}
