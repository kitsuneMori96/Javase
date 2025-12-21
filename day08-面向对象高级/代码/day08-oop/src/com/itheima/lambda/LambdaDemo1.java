package com.itheima.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 目标：认识Lambda表达式：搞清楚其基本作用。
        Animal a = new Animal() {
            @Override
            public void cry() {
                System.out.println("🐱是喵喵喵的叫~~~~");
            }
        };
        a.cry();

        // 错误示范：Lambda并不是可以简化全部的匿名内部类，Lambda只能简化函数式接口的匿名内部类。
//        Animal a1 = () -> {
//            System.out.println("🐱是喵喵喵的叫~~~~");
//        };
//        a1.cry();

        System.out.println("=====================================================");

       /* Swim s1 = new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生🏊‍贼快~~~~");
            }
        }; */

        // Lambda只能简化函数式接口的匿名内部类。
        Swim s1 = () -> {
            System.out.println("学生🏊‍贼快~~~~");
        };
        s1.swimming();
    }
}

abstract class Animal{
    public abstract void cry();
}

// 函数式接口：只有一个抽象方法的接口。
@FunctionalInterface // 声明函数式接口的注解。
interface Swim{
    void swimming();
}
