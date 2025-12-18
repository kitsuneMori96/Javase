package com.itheima.interface4;

public class Test {
    public static void main(String[] args) {
        // 目标：搞清楚接口JDK 8新增的三种方法，并理解其好处。
        AImpl a = new AImpl();
        a.go();
        A.show(); // 静态方法'
    }
}

class AImpl implements A{

}