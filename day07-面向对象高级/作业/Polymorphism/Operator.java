package Polymorphism;

public class Operator {

    public static void work(Animal animal){
        if(animal instanceof Dog){
            ((Dog)animal).lookHome();
        }
        else{
            ((Cat)animal).catchMouse();
        }
    }
}
