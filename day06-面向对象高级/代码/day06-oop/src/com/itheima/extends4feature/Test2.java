package com.itheima.extends4feature;

public class Test2 {
    public static void main(String[] args) {
        // 目标2：继承后子类的访问特点：就近原则。
        Zi zi = new Zi();
        zi.show();
    }
}

class Fu{
    String name = "fu的name";
    public void run(){
        System.out.println("fu类的run方法");
    }
}

class Zi extends Fu{
    String name = "zi的name";
    public void show() {
        String name = "show的name";
        System.out.println(name); // show的name
        System.out.println(this.name); // zi的name
        System.out.println(super.name); // fu的name

        run(); // 子类的
        super.run(); // 父类的

    }

    public void run(){
        System.out.println("zi类的run方法");
    }
}
