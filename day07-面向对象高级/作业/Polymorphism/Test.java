package Polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a1= new Dog("Tom", 30);
        Animal a2= new Cat("Jerry", 25);
        a1.eat();
        Operator.work(a1);
        a2.eat();
        Operator.work(a2);
    }
}
