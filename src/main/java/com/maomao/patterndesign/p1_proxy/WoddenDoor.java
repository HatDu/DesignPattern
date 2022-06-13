package com.maomao.patterndesign.p1_proxy;

public class WoddenDoor implements Door{

    @Override
    public String open(String userName) {
        return userName + "经过此木门，经验加3";
    }
    
}
