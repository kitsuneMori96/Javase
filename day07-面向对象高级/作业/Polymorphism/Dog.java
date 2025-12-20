package Polymorphism;

public class Dog extends Animal {

    public Dog(String name,double weight) {
        super(name, weight);
    }

    @Override
    public void eat() {
         System.out.println("Dog is eating");
    }

    public void lookHome(){
         System.out.println("Dog is looking home");
    }
}
