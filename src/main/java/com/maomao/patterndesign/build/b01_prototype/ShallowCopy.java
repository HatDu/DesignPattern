package com.maomao.patterndesign.build.b01_prototype;

class Person implements Cloneable{
    public String name;
    public Person(String name){
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.name = new String(person.name);
        return person;
    }
}

public class ShallowCopy {
    public static void main(String[] args) {
        Person zhang = new Person("zhangsan");
        try {
            Person zhou = (Person) zhang.clone();
            System.out.println(zhang.name == zhou.name);
            // 输出true
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
