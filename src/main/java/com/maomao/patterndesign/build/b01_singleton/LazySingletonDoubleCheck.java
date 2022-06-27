package com.maomao.patterndesign.build.b01_singleton;

public class LazySingletonDoubleCheck {
    private static volatile LazySingletonDoubleCheck instance;

    private LazySingletonDoubleCheck(){};

    public LazySingletonDoubleCheck getInstance(){
        if(instance == null){
            synchronized(LazySingletonDoubleCheck.class){
                if(instance == null){
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
