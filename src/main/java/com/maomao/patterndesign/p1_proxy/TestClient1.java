package com.maomao.patterndesign.p1_proxy;

public class TestClient1 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = new LogStaticProxy(userDao);

        proxy.setUserInfo("我是static proxy");

        System.out.println(proxy.getUserInfo());

        // 输出
        // log beforeTue Jun 14 20:10:06 CST 2022
        // 插入信息：我是static proxy
        // log afterTue Jun 14 20:10:06 CST 2022
        // log beforeTue Jun 14 20:10:06 CST 2022
        // 获取信息：我是static proxy
        // log afterTue Jun 14 20:10:06 CST 2022
        // 我是static proxy
    }
}
