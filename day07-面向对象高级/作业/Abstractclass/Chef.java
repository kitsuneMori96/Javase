package Abstractclass;


import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Chef extends People{

    public Chef(String id, String name, double i) {
        super(id, name, i);
    }

    @Override
    public void work() {
        System.out.println(getId()+getName() +getSalary()+"厨师正在炒菜...");
    }

    @Override
    public void eat() {
         System.out.println(getId()+getName() +getSalary()+"厨师正在吃肉...");
    }
}
