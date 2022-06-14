package com.maomao.patterndesign.p1_proxy;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class LogMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object rst = methodProxy.invokeSuper(object, args);
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
