package com.maomao.patterndesign.build.b01_singleton;

public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){};

    public static HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }
}
