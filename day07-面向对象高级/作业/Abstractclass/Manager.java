package Abstractclass;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Manager extends People{

    public Manager(String id, String name, double i) {
        super(id, name, i);
    }

    @Override
    public void work() {
        System.out.println(getId()+getName() +getSalary()+ "经理在管理其他人");
    }

    @Override
    public void eat() {
        System.out.println(getId()+getName() +getSalary()+"经理在吃鱼");
    }
}
