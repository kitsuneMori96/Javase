package day06;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Card {
    private String carId;
    private String name;
    private int phone; // 卡号
    private double money;

    public void consume(double money){
        if(this.money > money) this.money -= money;
        else System.out.println("余额不足");
        System.out.println("当前余额: " + this.money);
    }

    public void deposit(double money){
        this.money += money;
    }

    public void show(){
        System.out.println("卡号: " + carId + ", 姓名: " + name + ", 手机号: " + phone + ", 余额: " + money);
    }

}


