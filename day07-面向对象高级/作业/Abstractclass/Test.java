package Abstractclass;

public class Test {
    public static void main(String[] args) {
        People p1= new Chef("p001","小李",7000);
        People p2 = new Manager("p002", "Tom", 50000);
        p2.work();
        p2.eat();
        System.out.println("---------------");
        p1.work();
        p1.eat();
    }
}
