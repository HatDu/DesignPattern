package com.maomao.patterndesign.p1_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

class GuardInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy methodProxy) throws Throwable {
        String userName = (String) args[0];

        preInvoke(userName);

        String rst = null;
        if(userName!=null && userName.contains("z")){
            rst = (String) methodProxy.invokeSuper(obj, args);
        }
        else{
            rst = userName + "无权经过此门";
        }
        System.out.println(rst);
        postInvoke(userName);
        return rst;
    }
    
    private void preInvoke(String userName){
        System.out.println(userName + "尝试经过此门");
    }

    private void postInvoke(String userName){
        System.out.println(userName + "经过了此门");
    }
}

public class DoorGuardCglibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(WoddenDoor.class);
        // 设置回调函数
        enhancer.setCallback(new GuardInterceptor());
        WoddenDoor door = (WoddenDoor) enhancer.create();
        door.open("zhang san");
    }
}
