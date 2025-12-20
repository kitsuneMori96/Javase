package Polymorphism;

public class Cat extends Animal {

    public Cat(String name, double weight) {
        super(name, weight);
    }
    @Override
    public void eat() {
         System.out.println("Cat is eating.");
    }

    public void catchMouse(){
        System.out.println("Cat is catching mouse.");
    }
}
