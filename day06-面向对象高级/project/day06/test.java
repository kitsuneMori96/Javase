package day06;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        GoldenCard goldenCard = new GoldenCard("粤AAAAA", "张三", 123456789, 5000);
        SliverCard sliverCard = new SliverCard("赣BBBBB", "李四", 12345, 2000);
        pay(goldenCard);
        pay(sliverCard);
        goldenCard.deposit(500000);
        goldenCard.show();
        sliverCard.show();
    }

    public static void pay(Card card){
        System.out.println("请刷卡,输入当前消费金额");
        Scanner sc= new Scanner(System.in);
        double money = sc.nextDouble();
        card.consume(money);

    }

}
