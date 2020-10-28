package com.liu.sourceProject.design.pattern.decorator;

public class Phone implements IPhone {
    @Override
    public String callIn() {
        System.out.println("callIn...");
        return "get info";
    }
}
