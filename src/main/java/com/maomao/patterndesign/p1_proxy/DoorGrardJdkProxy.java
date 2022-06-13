package com.maomao.patterndesign.p1_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class GuardInvocationHandler implements InvocationHandler{
    Object target;

    public GuardInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String userName = (String) args[0];

        preInvoke(userName);

        String rst = null;
        if(userName!=null && userName.contains("z")){
            rst = (String) method.invoke(this.target, args);
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

public class DoorGrardJdkProxy {
    public static void main(String[] args) {
        WoddenDoor woddenDoor = new WoddenDoor();
        InvocationHandler guard = new GuardInvocationHandler(woddenDoor);

        Door proxyDoor = (Door)Proxy.newProxyInstance(woddenDoor.getClass().getClassLoader(), 
            woddenDoor.getClass().getInterfaces(), guard);
        proxyDoor.open("zhang san");
    }
}
