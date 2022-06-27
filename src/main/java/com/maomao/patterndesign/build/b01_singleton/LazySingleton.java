package com.maomao.patterndesign.build.b01_singleton;

public class LazySingleton {
    // 声明类静态类型
    private static volatile LazySingleton lazySingleton;

    private LazySingleton(){}

    // 静态方法
    public static synchronized LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton(); 
        }
        return lazySingleton;
    }
}
