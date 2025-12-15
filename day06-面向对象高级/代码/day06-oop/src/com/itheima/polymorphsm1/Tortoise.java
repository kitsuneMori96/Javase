package com.itheima.polymorphsm1;

public class Tortoise extends Animal{
    String name = "乌龟";
    @Override
    public void run() {
        System.out.println("🐢跑的贼慢~~~");
    }
}
