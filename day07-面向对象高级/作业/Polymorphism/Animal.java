package Polymorphism;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public abstract class Animal {
    private String name;
    private double weight;

    public abstract void eat();
}
