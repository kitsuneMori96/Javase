package com.itheima.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目标：加油站支付小程序。
        // 1、创建卡片类，以便创建金卡或者银卡对象，封装车主的数据。
        // 2、定义一个卡片父类：Card,定义金卡和银卡的共同属性和方法。
        // 3、定义一个金卡类，继承Card类：金卡必须重写消费方法（8折优惠），独有功能打印洗车票。
        // 3、定义一个银卡类，继承Card类：银卡必须重写消费方法（9折优惠）
        // 4、办一张金卡：创建金卡对象。交给一个独立的业务（支付机）来完成：存款，消费。
        GoldCard goldCard = new GoldCard("鄂A860MM", "dlei", "18665616520", 5000);
        goldCard.deposit(100); // 再存100
        pay(goldCard);

        // 4、办一张银卡：创建银卡对象。交给一个独立的业务（支付机）来完成：存款，消费。
        SilverCard silverCard = new SilverCard("粤A88888", "dlei", "18984724244", 2000);
        pay(silverCard);
    }

    // 支付机：用一个方法来刷卡： 可能接收金卡，也可能接收银卡。
    public static void pay(Card c){
        System.out.println("请刷卡,请您输入当前消费的金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
}
