package com.maomao.patterndesign.p1_proxy;

import java.lang.reflect.Proxy;


public class TestClient2 {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 1. 创建代理对象
        UserDao userDao = new UserDaoImpl();
        // 2. 创建代理的处理类
        LogJdkHandler handler = new LogJdkHandler(userDao);
        // 3. 使用Proxy.newProxyInstance生成代理对象
        UserDao proxy = (UserDao)Proxy.newProxyInstance(
            userDao.getClass().getClassLoader(), 
            userDao.getClass().getInterfaces(), 
            handler);
        
        proxy.setUserInfo("我是jdk proxy");
        System.out.println(proxy.getUserInfo());
        // 输出：
        // 插入信息：我是jdk proxy
        // log afterTue Jun 14 20:45:20 CST 2022
        // log beforeTue Jun 14 20:45:20 CST 2022
        // 获取信息：我是jdk proxy
        // log afterTue Jun 14 20:45:20 CST 2022
        // 我是jdk proxy
    }
}
