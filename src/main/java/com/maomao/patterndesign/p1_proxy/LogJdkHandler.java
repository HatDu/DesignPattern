package com.maomao.patterndesign.p1_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogJdkHandler implements InvocationHandler{
    private Object target;

    public LogJdkHandler(Object userDao) {
        this.target = userDao;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy是动态生成的代理类的对象
        // method是被触发的方法
        // args是方法入参列表
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
    
    private void before(){
        System.out.println("log before" + (new Date().toString()));
    }

    private void after(){
        System.out.println("log after" + (new Date().toString()));
    }
}
